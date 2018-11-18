
public class Car extends Vehicle{

	//This will change the spacetaken and size for the car
	//Since it extends the vehicle, it has access to the functions in the vehicle class
	public Car() {
		spaceTaken =1;
		size = Size.MEDIUM;
	}
}
