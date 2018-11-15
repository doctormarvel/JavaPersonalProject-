
public class ParkingLevels {
	private int SPOTS_PER_LEVEL = 30;
	private int SPOTS_PER_ROW = 10;
	private ParkingSpots[] spotsInRow;
	private Size spotSize;
	private int motorcycleSpots;
	private int carSpots;
	private int busSpots;
	
	public ParkingLevels () {
		this.spotsInRow = new ParkingSpots[SPOTS_PER_LEVEL];
	}
	
	public ParkingLevels(int spots, int spr) {
		this.spotsInRow = new ParkingSpots[spots];
		SPOTS_PER_ROW = spr;
		SPOTS_PER_LEVEL = spots;
		motorcycleSpots = (int)(spots *(20.0f/100.0f));
		busSpots = (int)(spots*(20.0f/100.0f));
		carSpots = spots - busSpots - motorcycleSpots;
		
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
	
	public int findFirstSpot (Vehicle vehicle) {
		int spotFound = -1; //temp variable to hold spot
		for (int i = 0; i < SPOTS_PER_LEVEL; i++) {
			if (vehicle.getSize() == Size.LARGE && spotsInRow[i].emptySpot()) {
				if(spotsInRow[i].getSpotSize()== Size.LARGE) {
					spotFound = i;
					break;
				}
				else {
					spotFound = -1;
					break;
				}
			}
			if (vehicle.getSize() == Size.MEDIUM && spotsInRow[i].emptySpot()) {
				if (spotsInRow[i].getSpotSize()== Size.LARGE || spotsInRow[i].getSpotSize()== Size.MEDIUM) {
					spotFound = i;
					break;
				}
				else {
					spotFound = -1;
					break;
				}
			}
			if (vehicle.getSize() == Size.SMALL && spotsInRow[i].emptySpot()) {
				if (spotsInRow[i].getSpotSize()== Size.LARGE || spotsInRow[i].getSpotSize()== Size.MEDIUM || spotsInRow[i].getSpotSize()== Size.SMALL) {
					spotFound = i;
					break;
				}
				else {
					spotFound = -1;
					break;
				}
			}
		}
		return spotFound;
	}
	
	public int getSpotsPerLevel () {
		return this.SPOTS_PER_LEVEL;
	}
	
	public ParkingSpots getParkingSpots(int index) {
		return spotsInRow[index];
	}
	
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
