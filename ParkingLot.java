
public class ParkingLot {
	private int NUM_OF_LEVELS = 5;
	private ParkingLevels[] level;//an array of levels that are in the garage
	private int totalSpots;
	
	//default constructor 
	public ParkingLot() {
		this.level = new ParkingLevels[NUM_OF_LEVELS];
	}
	
	//Overloaded constructor for parking lot
	public ParkingLot(int spots, int spr, int lvl) {
		this.level = new ParkingLevels[lvl];
		this.totalSpots = spots*lvl;
		this.NUM_OF_LEVELS = lvl;
		
		for (int i = 0; i < lvl; i++) {
			level[i] = new ParkingLevels(spots,spr);
		}
	}
	
	//park method, pulls functions from parkingLevels and vehicle to check to see if we can park in the spot
	public void park (Vehicle vehicle) {
		int spotReturned = -1;
		for (int i = 0; i < level.length; i++) {
			spotReturned = level[i].findFirstEmptySpot(vehicle);
			if(spotReturned != -1) {
				for(int j = 0; j < vehicle.getSpaceTaken(); j++) {
					level[i].placeVehicle(vehicle, spotReturned+j);
				}
				break;
			}
			else if (spotReturned == -1 && i + 1 == level.length){
				System.out.println("There is no room in the lot");
			}
		}
	}
	
	//specific parking method
	public void specificPark (Vehicle vehicle, int ourLevel, int row, int spot) {
		if (level[ourLevel].findSpecificSpot(vehicle, row, spot)) {
			for (int i = 0; i < vehicle.getSpaceTaken(); i++)
				level[ourLevel].placeVehicle(vehicle, row, spot+i);
		}
	}
	
	//remove method, pulls functions from parkingLevels and vehicle to check to see if we can remove a vehicle in the spot
	public void remove (Vehicle vehicle) {
		int spotReturned = -1;
		for(int i = 0; i < level.length; i++) {
			spotReturned = level[i].findFirstFullSpot(vehicle);
			if(spotReturned != -1) {
				for(int j = 0; j < vehicle.getSpaceTaken(); j++) {
					level[i].removeVehicle(spotReturned+j);
				}
				break;
			}
			else if (spotReturned == -1 && i + 1 == level.length) {
				System.out.println("There is no vehicle in the lot");
			}
		}
	}
	
	//specific remove method
	public void specificRemove(Vehicle vehicle, int ourLevel, int row, int spot) {
		int firstBusSpot = level[ourLevel].findFirstBusSpot(row, spot);
		System.out.println("first bus spot = " + firstBusSpot);
		if(level[ourLevel].findSpecificFullSpot(vehicle, row, spot)) {
			if(vehicle.getSize() == Size.MEDIUM || vehicle.getSize() == Size.SMALL) {
				level[ourLevel].removeVehicle(row, spot);
			}
			else if(vehicle.getSize() == Size.LARGE) {
				for(int i = 0; i < vehicle.getSpaceTaken(); i++) {
					level[ourLevel].removeVehicle(row, firstBusSpot+i);
					System.out.println("This is i " + i);
				}
			}
		}
	}
	
	//This toString splits the garage into levels
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < NUM_OF_LEVELS; i++) {
			sb.append("Level " + i + ": " +level[i] + "\n");
		}
		return sb.toString();
	}
	
	public int getTotalSpots () {
		return this.totalSpots;
	}
	
}
