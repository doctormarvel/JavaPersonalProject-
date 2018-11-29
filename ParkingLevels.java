
public class ParkingLevels {
	private int SPOTS_PER_LEVEL = 30;
	private int SPOTS_PER_ROW = 10;
	private ParkingSpots[] spotsInRow; //an array of spots that are available
	private Size spotSize;
	private int motorcycleSpots;
	private int carSpots;
	private int busSpots;
	private boolean pass;//this boolean is used to break for loops. Helps with structure
	
	public ParkingLevels () {
		this.spotsInRow = new ParkingSpots[SPOTS_PER_LEVEL];
	}
	
	//Overloaded constructor, the default constructor will probably never be used since we are asking for input
	public ParkingLevels(int spots, int spr) {
		this.spotsInRow = new ParkingSpots[spots];
		SPOTS_PER_ROW = spr;
		SPOTS_PER_LEVEL = spots;
		motorcycleSpots = (int)(spots *(20.0f/100.0f));//taking 20% of the spots and gathering an int for motorcycle spots
		busSpots = (int)(spots*(20.0f/100.0f)); //taking 20% of the spots and gathering an int for bus spots
		carSpots = spots - busSpots - motorcycleSpots;
		
		//This is where we create our spots in the parking level.
		for (int i = 0; i < spots; i++) {
			if (busSpots > 0) {
				spotsInRow[i] = new ParkingSpots(spotSize.LARGE);
				busSpots--;
			}else if (carSpots > 0 && busSpots==0) {
				spotsInRow[i] = new ParkingSpots(spotSize.MEDIUM);
				carSpots--;
			}else {
				spotsInRow[i] = new ParkingSpots(spotSize.SMALL);
			}
		}
	}
	
	//Finding the first empty spot in the garage
	public int findFirstEmptySpot (Vehicle vehicle) {
		int spotFound = -1; //temp variable to hold spot found
		pass = true;
		for (int i = 0; i < SPOTS_PER_LEVEL && pass; i++) {
			if (vehicle.getSize() == Size.LARGE && spotsInRow[i].emptySpot()) {
				if(spotsInRow[i].getSpotSize()== Size.LARGE) {
					spotFound = i;
					for (int check = 0; check < 5 && pass; check++) {
						if (spotsInRow[i+check].getSpotSize() != Size.LARGE) {
							spotFound = -1;
							pass = false;
						}
						else if(!spotsInRow[i+check].emptySpot()) {
							spotFound = -1;
							pass = false;
						}
					}
					//This will break the for loop
					if(spotFound != -1) {
						pass = false;
					}
				}
				//Nothing was found so return -1
				else {
					spotFound = -1;
					pass = false;
				}
			}
			if (vehicle.getSize() == Size.MEDIUM && spotsInRow[i].emptySpot()) {
				if (spotsInRow[i].getSpotSize()== Size.LARGE || spotsInRow[i].getSpotSize()== Size.MEDIUM) {
					spotFound = i;
					pass = false;
				}
				else {
					spotFound = -1;
					pass = false;
				}
			}
			if (vehicle.getSize() == Size.SMALL && spotsInRow[i].emptySpot()) {
				if (spotsInRow[i].getSpotSize()== Size.LARGE || spotsInRow[i].getSpotSize()== Size.MEDIUM || spotsInRow[i].getSpotSize()== Size.SMALL) {
					spotFound = i;
					pass = false;
				}
				else {
					spotFound = -1;
					pass = false;
				}
			}
		}
		return spotFound;
	}
	
	//Finding the first full spot in the garage
	public int findFirstFullSpot (Vehicle vehicle) {
		int spotFound = -1; //temp variable to find the first spot
		pass = true;
		for (int i = 0; i <SPOTS_PER_LEVEL && pass; i++) {
			if (!spotsInRow[i].emptySpot() && vehicle.getSize() == spotsInRow[i].getVehicle().getSize()) {
				spotFound = i;
				pass = false;
			}
		}
		return spotFound;
	}
	
	/*This function will find a specific spot the user wants, it returns a boolean
	if it returns true, then we can park there because nothing there, if it's 
	false we let the user know it's full
	*/
	public boolean findSpecificSpot(Vehicle vehicle, int row, int spot) {
		int newSpot = (row - 1) * SPOTS_PER_ROW + spot-1; // We need a new variable because the spot that we use won't be the same
		int temp = newSpot; //This will help stop a bus from overflowing to the other row
		pass = true;
		if(spotsInRow[newSpot].emptySpot()) {
			if (vehicle.getSize() == Size.SMALL) {
				{
					if (spotsInRow[newSpot].getSpotSize() == Size.SMALL || spotsInRow[newSpot].getSpotSize() == Size.MEDIUM || spotsInRow[newSpot].getSpotSize() == Size.LARGE) {
						pass = true;
					}
					else {
						System.out.println("There is an error with the motorcycle..... how does that happen?");
						pass = false;
					}
				}
			}
			else if(vehicle.getSize() == Size.MEDIUM) {
				if (spotsInRow[newSpot].getSpotSize() == Size.MEDIUM || spotsInRow[newSpot].getSpotSize() == Size.LARGE) {
					pass = true;
				}
				else {
					pass = false;
					System.out.println("No room for the car");
				}
			}
			//this has to be broken apart to work
			else if (vehicle.getSize() == Size.LARGE) {
				for (int i = 0; i < 5 && pass; i++) {
					if (spotsInRow[newSpot + i].getSpotSize() != Size.LARGE) {
						System.out.println("No room for the bus");
						pass = false;
					}
					else if (!spotsInRow[newSpot + i].emptySpot()) {
						System.out.println("No room for the bus");
						pass = false;
					}
					else if ( temp % SPOTS_PER_ROW == 0 && i != 0) {
						System.out.println("No room for the bus");
						pass = false;
					}
					else
					{
						System.out.println("This is temp: "+ temp);
						System.out.println("This is i: " + i);
						temp++;
					}
				}
			}
			else {
				System.out.println("We have an error finding the size in findSpecificSpot");
				pass = false;
			}
		}
		else if(!spotsInRow[newSpot].emptySpot()) {
			pass = false;
			System.out.println("There is no room in that spot");
		}
		else {
			System.out.println("There was an error finding the spot");
			pass = false;
		}
		return pass;
	}
	
	//Can not recycle other method, can be exploited since it will return false for many reasons which will cause a delete in an area where it should not happen
	public boolean findSpecificFullSpot(Vehicle vehicle, int row, int spot) {
		int newSpot = (row - 1) * SPOTS_PER_ROW + spot-1; // We need a new variable because the spot that we use won't be the same
		pass = true;
		if(!spotsInRow[newSpot].emptySpot()) {
			if(vehicle.getSize() == spotsInRow[newSpot].getVehicle().getSize()) {
				pass = true;
			}
			else {
				System.out.println("There does not seem to be a vehicle there");
				pass = false;
			}
		}
		else {
			System.out.println("There is nothing in that spot");
			pass = false; 
		}
		return pass;
	}
	
	//This method will be used if the space that is taken is greater than 1. Means it will only be used for busses
	//We are checking to see if there are any busses ahead of the bus that we are removing. If there are then we need to remove them according to where they are placed
	public int findFirstBusSpot (Vehicle vehicle, int row, int spot) {
		int newSpot = (row - 1) * SPOTS_PER_ROW + spot; // We need a new variable because the spot that we use won't be the same
		System.out.println("this is new spot " + newSpot);
		int returnedSpot = 0;
		int calcBusNumber = 0;
		int firstSpot = 0;
		for (int i = newSpot; i > 0; i--) {
			if (spotsInRow[i].emptySpot() || spotsInRow[newSpot].getVehicle().getSize() != Size.LARGE) {
				System.out.println("This is returned Spot = " + returnedSpot);
				break;
			}
			else {
				returnedSpot = i;
			}
		}
		calcBusNumber = (newSpot - returnedSpot)/5;
		System.out.println("This is the bus number  = " + calcBusNumber);
		firstSpot = returnedSpot + (calcBusNumber * 5);
		System.out.println("This is the firstBus= " + firstSpot);
		return firstSpot;
	}
	
	//this function will remove a vehicle in a specific spot
	public void removeVehicle (int spot) {
		spotsInRow[spot].setVehicle(null);
	}
	
	//overloaded method, only used for specific remove
	public void removeVehicle (int row, int spot) {
		int newSpot = (row - 1) * SPOTS_PER_ROW + spot-1;
		spotsInRow[newSpot].setVehicle(null);
	}
	
	//This function will place a vehicle in a specific spot
	public void placeVehicle (Vehicle vehicle, int spot) {
		spotsInRow[spot].setVehicle(vehicle);
	}
	
	//Overloaded method only used for specific park
	public void placeVehicle (Vehicle vehicle, int row, int spot) {
		int newSpot = (row - 1) * SPOTS_PER_ROW + spot-1;
		spotsInRow[newSpot].setVehicle(vehicle);
	}
	
	//This toString helps us split the level into rows
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int temp = 1; // This is used to help create each row evenly
		for(int i = 0; i < SPOTS_PER_LEVEL; i++) {
			if (temp % SPOTS_PER_ROW == 0 && i != 0) {
				sb.append(spotsInRow[i] + "   ");
			}
			else {
				sb.append(spotsInRow[i]);
			}
			temp++;
		}
		return sb.toString();
	}
}
