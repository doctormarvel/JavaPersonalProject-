
public class Bus extends Vehicle{
	
	//This will change the spacetaken and size for the bus
	//Since it extends the vehicle, it has access to the functions in the vehicle class
	public Bus () {
		spaceTaken = 5;
		size = Size.LARGE;
	}
}
