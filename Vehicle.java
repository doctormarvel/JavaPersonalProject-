
public class Vehicle {
	protected VehicleSize size;
	protected int spaceTaken;
	
	public Vehicle () {
	}
	
	public boolean canPark (Vehicle obj) {
		if(obj == null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void park (Vehicle obj) {
	}
	
	public VehicleSize getSize () {
		return this.size;
	}
	
	public int getSpaceTaken () {
		return this.spaceTaken;
	}
	
	
}
