
public class Vehicle {
	protected VehicleSize size;
	protected int spaceTaken;
	
	public Vehicle () {
	}
	
	public boolean canPark (ParkingSpots spot) {
		if(spot.emptySpot() && spot.getVehicleSize() == size) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void park (ParkingLot spots) {
	}
	
	public VehicleSize getSize () {
		return this.size;
	}
	
	public int getSpaceTaken () {
		return this.spaceTaken;
	}
	
	
}
