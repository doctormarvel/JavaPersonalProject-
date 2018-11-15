
public class ParkingLevels {
	private int SPOTS_PER_LEVEL = 30;
	private int SPOTS_PER_ROW = 10;
	private ParkingSpots[] spotsInRows;
	private VehicleSize spotSize;
	private int motorcycleSpots;
	private int carSpots;
	private int busSpots;
	
	public ParkingLevels () {
		this.spotsInRows = new ParkingSpots[SPOTS_PER_LEVEL];
	}
	
	public ParkingLevels(int spots, int spr) {
		this.spotsInRows = new ParkingSpots[spots];
		SPOTS_PER_ROW = spr;
		SPOTS_PER_LEVEL = spots;
		motorcycleSpots = (int)(spots *(20.0f/100.0f));
		busSpots = (int)(spots*(20.0f/100.0f));
		carSpots = spots - busSpots - motorcycleSpots;
		
		for (int i = 0; i < spots; i++) {
			if (busSpots > 0) {
				spotsInRows[i] = new ParkingSpots(spotSize.BUS);
				busSpots--;
//				System.out.println("This is how many bus spots" + busSpots);
//				System.out.println("This is how many car spots" + carSpots);
//				System.out.println("This is how many motor spots" + motorcycleSpots);
//				System.out.println("This is how many spots" + lvlSpots);
			}else if (carSpots > 0 && busSpots==0) {
				spotsInRows[i] = new ParkingSpots(spotSize.CAR);
				carSpots--;
//				System.out.println("This is how many bus spots" + busSpots);
//				System.out.println("This is how many car spots" + carSpots);
//				System.out.println("This is how many motor spots" + motorcycleSpots);
			}else {
				spotsInRows[i] = new ParkingSpots(spotSize.MOTORCYCLE);
//				System.out.println("This is how many bus spots" + busSpots);
//				System.out.println("This is how many car spots" + carSpots);
//				System.out.println("This is how many motor spots" + motorcycleSpots);
			}
		}
	}
	
	public int getSpotsPerLevel() {
		return this.SPOTS_PER_LEVEL;
	}
	
	public ParkingSpots getParkingSpots(int index) {
		return spotsInRows[index];
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int temp = 1; // This is used to help create each row evenly
		for(int i = 0; i < SPOTS_PER_LEVEL; i++) {
			if (temp % SPOTS_PER_ROW == 0 && i != 0) {
				sb.append(spotsInRows[i] + "   ");
			}
			else {
				sb.append(spotsInRows[i]);
			}
			temp++;
		}
		return sb.toString();
	}
}
