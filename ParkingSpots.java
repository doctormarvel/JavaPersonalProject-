
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
	
	public Vehicle getVehicle () {
		return this.vehicle;
	}
	
	public VehicleSize getVehicleSize() {
		return this.spotSize;
	}
	
	public void setVehicle (Vehicle veh) {
		this.vehicle = veh;
	}
	
	//don't think I need this method
	public void setVehicleSize (VehicleSize size) {
		this.spotSize = size;
	}
	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		if (!emptySpot()) {
			if (vehicle instanceof Bus) {
				sb.append('B');
			}else if (vehicle instanceof Car) {
				sb.append('C');
			}else {
				sb.append('M');
			}
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
