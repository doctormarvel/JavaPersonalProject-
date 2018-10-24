
public class ParkingSpots {
	private VehicleSize spotSize;
	private Vehicle vehicle;
	
	public ParkingSpots() {}
	
	public ParkingSpots(VehicleSize size) {
	this.spotSize = size;
	this.vehicle = null;
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
				//System.out.println("bus is called");
				sb.append('l');
			}else if(spotSize == VehicleSize.CAR) {
				//System.out.println("car is called");
				sb.append('c');
			}else {
				//System.out.println("motor is called");
				sb.append('m');
			}
		}
		return sb.toString();
	}
}
