
public class Bus extends Vehicle{
	
	public Bus () {
		spaceTaken = 5;
		size = VehicleSize.BUS;
	}
	
	public void park (ParkingLot spots) {
		for (int i = 0; i < spots.getNumOfLevels(); i++) {
			int temp = 1; // temp variable to count open spots for bus. Starts at one because it should already pass
			for (int j = 0; j < spots.getParkingLevels(i).getSpotsPerLevel(); j++) {
				if (canPark(spots.getParkingLevels(i).getParkingSpots(j))) {
					while (temp != 5) {
						for (temp = 1; temp <5; temp++) {
							if (canPark(spots.getParkingLevels(i).getParkingSpots(j))) {
								System.out.println("Bus print = " + temp);
							}
							else {
								System.out.println("The bus can not fit");
								break;
							}
						}
					}
				}
				//this will need to return back that if there is no spot available then let the user know
				else if (i == spots.getNumOfLevels() && j == spots.getParkingLevels(i).getSpotsPerLevel()) {
					System.out.println("There are no available spots");
				}
				else {
					System.out.println("Came across an error in Bus loop");
				}
			}
		}
	}
	
}
