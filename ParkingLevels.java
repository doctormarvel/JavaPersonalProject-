
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
					for (int check = 0; check < 5 & pass; check++) {
						if (spotsInRow[i+check].getSpotSize() != Size.LARGE && spotsInRow[i].emptySpot()) {
							spotFound = -1;
							pass = false;
						}
					}
					if(spotFound != -1) {
						pass = false;
					}
				}
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
	
	//this function will remove a vehicle in a specific spot
	public void removeVehicle (int spot) {
		spotsInRow[spot].setVehicle(null);
	}
	
	//This function will place a vehicle in a specific spot
	public void placeVehicle (Vehicle vehicle, int spot) {
		spotsInRow[spot].setVehicle(vehicle);
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
