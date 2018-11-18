
public class ParkingLot {
	private int NUM_OF_LEVELS = 5;
	private ParkingLevels[] level;
	private int totalSpots;
	
	public ParkingLot(int spots, int spr, int lvl) {
		this.level = new ParkingLevels[lvl];
		this.totalSpots = spots*lvl;
		this.NUM_OF_LEVELS = lvl;
		
		for (int i = 0; i < lvl; i++) {
			level[i] = new ParkingLevels(spots,spr);
		}
	}
	
	public int getNumOfLevels () {
		return this.NUM_OF_LEVELS;
	}
	
	public ParkingLevels getParkingLevels(int index) {
		return level[index];
	}
	
	public void Park (Vehicle vehicle) {
		int spotReturned = -1;
		for (int i = 0; i < level.length; i++) {
			spotReturned = level[i].findFirstEmptySpot(vehicle);
			System.out.println("The spot that is returned = " + spotReturned);
			if(spotReturned != -1) {
				for(int j = 0; j < vehicle.getSpaceTaken(); j++) {
					level[i].placeVehicle(vehicle, spotReturned+j);
				}
				break;
			}
			else {
				System.out.println("There is a problem in park");
			}
		}
	}
	
	public void Remove (Vehicle vehicle) {
		int spotReturned = -1;
		for(int i = 0; i < level.length; i++) {
			spotReturned = level[i].findFirstFullSpot(vehicle);
			if(spotReturned != -1) {
				for(int j = 0; j < vehicle.getSpaceTaken(); j++) {
					level[i].removeVehicle(spotReturned+j);
				}
				break;
			}
			else {
				System.out.println("There was a problem in remove");
			}
		}
	}
	
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
