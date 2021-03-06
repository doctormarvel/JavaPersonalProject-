import java.util.*;

/*
Larry Kridner
CS 2336.006
To run the code with the default numbers you just need to enter a 0 for the level, rows, and spots. The input is case sensitive so if you enter it wrong you will be asked again.
To end the program either type end while you see the parking lot or come across a error
*/

public class DriverClass {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		ParkingLot lot;
		Car car;
		Bus bus;
		Motorcycle motorcycle;
		
		int numberOfSpots = 0;
		int spotsPerRow = 0;
		int numberOfLevels = 0;
		boolean testPass = true; // to help with the while loop
		String userInput;
		int userLevel = 0;
		int userRow = 0;
		int userSpot = 0;
		
		//total number of levels
		System.out.println("How many levels are there?");
		testPass = true; 
		while (testPass) {
			try {
				numberOfLevels = Integer.parseInt(input.next());
				if (numberOfLevels == 0) {
					numberOfLevels = 5;
				}
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//total number of spots per row
		System.out.println("How many spots per row are there?");
		testPass = true; 
		while (testPass) {
			try {
				spotsPerRow = Integer.parseInt(input.next());
				if (spotsPerRow == 0) {
					spotsPerRow = 10;
				}
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//Total number of spots in a level
		System.out.println("How many spots are there per level?");
		testPass = true; 
		while (testPass) {
			try {
				numberOfSpots = Integer.parseInt(input.next());
				if (numberOfSpots == 0) {
					numberOfSpots = 30;
				}
				testPass = false;
			} catch(NumberFormatException e){
				System.out.println("not a valid number, try again");
			}
		}
		
		//Creating the lot using the constructor 
		lot = new ParkingLot(numberOfSpots, spotsPerRow, numberOfLevels);
		
		System.out.println(lot);
		
		//While loop that will continue till there are no more spots or until the user tells the program to end
		while (true) {
			System.out.println("Type \"park or (1)\" to park a vehicle, \"specificP or (2)\" to park in a specific spot, \"remove or (3)\" to remove a vehicle, \"specificR or (4)\" to reomve a specific vehicle, or type \"end or (5)\" to end the program");
			userInput = input.next();
			if(userInput.equals("park") || userInput.equals("1")) {
				System.out.println("What would you like to park, a bus (1), a car (2), or a motorcycle (3)?");
				userInput = input.next();
				if (userInput.equals("bus") || userInput.equals("1")) {
					bus = new Bus();
					lot.park(bus);
				}
				else if (userInput.equals("car") || userInput.equals("2")) {
					car = new Car();
					lot.park(car);
				}
				else if (userInput.equals("motorcycle") || userInput.equals("3")) {
					motorcycle = new Motorcycle();
					lot.park(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to park, try again");
				}
			}
			
			else if (userInput.equals("specificP") || userInput.equals("2")) {
				System.out.println("What level would you like to park in?");
				testPass = true;
				while (testPass) {
					userLevel = Integer.parseInt(input.next());
					if (userLevel >= 0 && userLevel <= numberOfLevels) {
						testPass = false;
					}
					else {
						System.out.println("That is not a level");
					}
				}
				
				System.out.println("What row would you like to park in?");
				testPass = true;
				while (testPass) {
					userRow = Integer.parseInt(input.next());
					if (userRow >= 0 && userRow <= numberOfSpots/spotsPerRow) {
						testPass = false;
					}
					else {
						System.out.println("That is not a row");
					}
				}
				
				System.out.println("What spot would you like to park in?");
				testPass = true;
				while (testPass) {
					userSpot = Integer.parseInt(input.next());
					if (userSpot >= 0 && userSpot <= spotsPerRow) {
						testPass = false;
					}
					else {
						System.out.println("That is not a spot");
					}
				}
				
				System.out.println("What would you like to park, a bus, a car, or a motorcycle?");
				testPass = true;
				while (testPass) {
					userInput = input.next();
					if (userInput.equals("bus") || userInput.equals("car") || userInput.equals("motorcycle")) {
						testPass = false;
					}
					else {
						System.out.println("That is not a vehicle");
					}
				}
				
				//After getting all of the users input
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.specificPark(bus, userLevel, userRow, userSpot);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.specificPark(car, userLevel, userRow, userSpot);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.specificPark(motorcycle, userLevel, userRow, userSpot);
				}
				else {
					System.out.println("Looks like that is not a vehicle to park, try again");
				}
			}
			
			else if (userInput.equals("remove") || userInput.equals("3")) {
				System.out.println("What type of vehicle would you like to remove, a bus, a car, or a motorcycle");
				userInput = input.next();
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.remove(bus);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.remove(car);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.remove(motorcycle);
				}
				else {
					System.out.println("Looks like that is not a vehicle to remove, try again");
				}
			}
			
			else if (userInput.equals("specificR") || userInput.equals("4")) {
				System.out.println("What level would you like to remove in?");
				testPass = true;
				while (testPass) {
					userLevel = Integer.parseInt(input.next());
					if (userLevel >= 0 && userLevel <= numberOfLevels) {
						testPass = false;
					}
					else {
						System.out.println("That is not a level");
					}
				}
				
				System.out.println("What row would you like to remove in?");
				testPass = true;
				while (testPass) {
					userRow = Integer.parseInt(input.next());
					if (userRow >= 0 && userRow <= numberOfSpots/spotsPerRow) {
						testPass = false;
					}
					else {
						System.out.println("That is not a row");
					}
				}
				
				System.out.println("What spot would you like to remove in?");
				testPass = true;
				while (testPass) {
					userSpot = Integer.parseInt(input.next());
					if (userSpot >= 0 && userSpot <= spotsPerRow) {
						testPass = false;
					}
					else {
						System.out.println("That is not a spot");
					}
				}
				System.out.println("What would you like to remove, a bus, a car, or a motorcycle?");
				testPass = true;
				while (testPass) {
					userInput = input.next();
					if (userInput.equals("bus") || userInput.equals("car") || userInput.equals("motorcycle")) {
						testPass = false;
					}
					else {
						System.out.println("That is not a vehicle");
					}
				}
				if (userInput.equals("bus")) {
					bus = new Bus();
					lot.specificRemove(bus, userLevel, userRow, userSpot);
				}
				else if (userInput.equals("car")) {
					car = new Car();
					lot.specificRemove(car, userLevel, userRow, userSpot);
				}
				else if (userInput.equals("motorcycle")) {
					motorcycle = new Motorcycle();
					lot.specificRemove(motorcycle, userLevel, userRow, userSpot);
				}
				else {
					System.out.println("Looks like that is not a vehicle to park, try again");
				}
			}
			
			else if (userInput.equals("end") || userInput.equals("5")) {
				System.out.println("\n\nEnding the program");
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
