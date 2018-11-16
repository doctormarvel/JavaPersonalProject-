
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
			spotReturned = level[i].findFirstSpot(vehicle);
			if(spotReturned == -1) {
				break;
			}
			else if (vehicle instanceof Bus) {
				for (int j =0; j < 5; j++) {
					level[i].placeVehicle(vehicle, spotReturned+j);
				}
			}
			else {
				System.out.println("There is a problem in park");
			}
		}
	}
	
	public void Remove () {
		
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
