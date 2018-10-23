
public class ParkingLevels {
	private int SPOTS_PER_LEVEL = 30;
	private ParkingRow[] row;
	private int rowCount;
	
	
	public ParkingLevels () {}
	
	public ParkingLevels(int spots, int spr) {
		this.row = new ParkingRow[spots/spr];
		this.rowCount = spots/spr;
		
		for (int i = 0; i < spots/spr; i++) {
			row[i] = new ParkingRow(spots,spr);
		}
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < rowCount; i++) {
			if (i == rowCount) {
				sb.append(row[i]);
			}else {
				sb.append(row[i] + "   ");
			}
		}
		return sb.toString();
	}
}
