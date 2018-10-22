
public class ParkingSpots {
	private VehicleSize spotSize;
	private Vehicle vehicle;
	
	public ParkingSpots() {}
	
	public ParkingSpots(VehicleSize size) {
	this.spotSize = size;
	}
	
	public boolean emptySpot () {
		return vehicle == null;
	}
	
	//public boolean parkCar () {
		
	//}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (!emptySpot()) {
			
		}
		else {
			if(spotSize == VehicleSize.BUS) {
				sb.append('l');
			}else if(spotSize == VehicleSize.CAR) {
				sb.append('c');
			}else if(spotSize == VehicleSize.MOTORCYCLE);{
				sb.append('m');
			}
		}
		return sb.toString();
	}
}
