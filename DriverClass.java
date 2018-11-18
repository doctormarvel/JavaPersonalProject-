import java.util.*;

public class DriverClass {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		ParkingLot lot;
		Vehicle vehicle;
		Car car;
		Bus bus;
		Motorcycle motorcycle;
		
		int numberOfSpots;
		int spotsPerRow;
		int numberOfLevels;
		
		String userInput;
		
		System.out.println("How many levels are there?");
		numberOfLevels = input.nextInt(); // need to convert this from string to int
		
		System.out.println("How many spots per row are there?");
		spotsPerRow = input.nextInt();
		
		System.out.println("How many spots are there per level?");
		numberOfSpots = input.nextInt();
		//Creating the lot using the constructor 
		lot = new ParkingLot(numberOfSpots, spotsPerRow, numberOfLevels);
		
		System.out.println(lot);
		//While loop that will continue till there are no more spots or until the user tells the program to end
		while (lot.getTotalSpots() != 0) {
			System.out.println("Type \"park\" to park a vehicle, \"remove\" to remove a vehicle or type \"end\" to end the program");
			userInput = input.next();
			if(userInput.equals("park")) {
				System.out.println("What would you like to park, a bus, a car, or a motorcycle?");
				userInput = input.next();
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.Park(bus);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.Park(car);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.Park(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to park, try again");
				}
			}
			else if (userInput.equals("remove")) {
				System.out.println("What type of vehicle would you like to remove, a bus, a car, or a motorcycle");
				userInput = input.next();
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.Remove(bus);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.Remove(car);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.Remove(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to remove, try again");
				}
			}
			else if (userInput.equals("end")) {
				break;
			}
			else {
				System.out.println("That's not an option, lets try again");
			}
			//Print the lot
			System.out.println("\nThis is the new lot");
			System.out.println(lot);
		}
		
	}
}
