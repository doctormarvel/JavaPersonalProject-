
public class Motorcycle extends Vehicle{
	
	//This will change the spacetaken and size for the motorcycle
	//Since it extends the vehicle, it has access to the functions in the vehicle class
	public Motorcycle () {
		spaceTaken = 1;
		size = Size.SMALL;
	}
}
