
public class ParkingRow {
	private int SPOTS_PER_ROW = 10;
	private ParkingSpots [] spots;
	private VehicleSize spotSize;
	private int motorcycleSpots;
	private int carSpots;
	private int busSpots;
	
	public ParkingRow() {
		this.spots = new ParkingSpots[SPOTS_PER_ROW];
	}
	
	public ParkingRow(int lvlSpots, int spr) {
		spots = new ParkingSpots[spr];
		SPOTS_PER_ROW = spr;
		motorcycleSpots = (int)(lvlSpots *(20.0f/100.0f));
		busSpots = (int)(lvlSpots*(20.0f/100.0f));
		carSpots = lvlSpots - busSpots - motorcycleSpots;
		
		for (int i = 0; i < spr; i++) {
			if (busSpots > 0) {
				spots[i] = new ParkingSpots(spotSize.BUS);
				busSpots--;
				System.out.println("This is how many bus spots" + busSpots);
				System.out.println("This is how many car spots" + carSpots);
				System.out.println("This is how many motor spots" + motorcycleSpots);
				System.out.println("This is how many spots" + lvlSpots);
			}else if (carSpots > 0 && busSpots==0) {
				spots[i] = new ParkingSpots(spotSize.CAR);
				carSpots--;
				System.out.println("This is how many bus spots" + busSpots);
				System.out.println("This is how many car spots" + carSpots);
				System.out.println("This is how many motor spots" + motorcycleSpots);
			}else {
				spots[i] = new ParkingSpots(spotSize.MOTORCYCLE);
				System.out.println("This is how many bus spots" + busSpots);
				System.out.println("This is how many car spots" + carSpots);
				System.out.println("This is how many motor spots" + motorcycleSpots);
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < SPOTS_PER_ROW; i++) {
			sb.append(spots[i]);
		}
		return sb.toString();
	}
}
