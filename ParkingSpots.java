
public class ParkingSpots {
	private Size spotSize;
	private Vehicle vehicle;
	
	public ParkingSpots() {}
	
	//overloaded constructor
	public ParkingSpots(Size size) {
	this.spotSize = size;
	this.vehicle = null;
	}
	
	//Returns true if the spot is empty
	public boolean emptySpot () {
		return vehicle == null;
	}
	
	//Returns the vehicle that is inside the parking spot
	public Vehicle getVehicle () {
		return this.vehicle;
	}
	
	//Returns the vehicle size that is in the spot
	public Size getSpotSize() {
		return this.spotSize;
	}
	
	//Sets the vehicle that is inside the spot
	public void setVehicle (Vehicle veh) {
		this.vehicle = veh;
	}
	
	//For the printout, when the system out is called this will be called. We are checking the spot with emptyspot
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
			if(spotSize == Size.LARGE) {
				sb.append('l');
			}else if(spotSize == Size.MEDIUM) {
				sb.append('c');
			}else {
				sb.append('m');
			}
		}
		return sb.toString();
	}
}
