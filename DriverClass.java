import java.util.*;

public class DriverClass {

	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		ParkingLot lot;
		
		int numberOfSpots;
		int spotsPerRow;
		int numberOfLevels;
		
		System.out.println("How many levels are there?");
		numberOfLevels = input.nextInt();
		
		System.out.println("How many spots per row are there?");
		spotsPerRow = input.nextInt();
		
		System.out.println("How many spots are there?");
		numberOfSpots = input.nextInt();
		
		lot = new ParkingLot(numberOfSpots, spotsPerRow, numberOfLevels);
		
		System.out.println(lot);
		
	}
}
