
public class Vehicle {
	protected Size size;
	protected int spaceTaken;
	
	//no need to specify what is in here since we will be changing it based on the vehicle that the user parks or removes
	public Vehicle () {
	}
	
	//Returns the size of the vehicle 
	public Size getSize () {
		return this.size;
	}
	
	//returns how many spots the vehicle can take. Only the bus should be taking up more than 1 spot
	public int getSpaceTaken () {
		return this.spaceTaken;
	}
	
	
}
