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
		
		lot = new ParkingLot(numberOfSpots, spotsPerRow, numberOfLevels);
		
		System.out.println(lot);
		
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
					
				}
				else if (userInput.equals("motorcycle")) {
					
				}
				else {
					System.out.println("Looks like we have bad input. Goodbye");
					break;
				}
			}
			else if (userInput.equals("remove")) {
				userInput = input.next();
				
			}
			else if (userInput.equals("end")) {
				break;
			}
			else {
				System.out.println("I think an error occured, see you later");
				break;
			}
			System.out.println("This is the new lot");
			System.out.println(lot);
		}
		
	}
}
