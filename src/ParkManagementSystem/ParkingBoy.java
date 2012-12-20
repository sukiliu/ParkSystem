package ParkManagementSystem;

public class ParkingBoy {
	private String parkingBoyNo;
	private String description;
	public ParkingBoy(String parkingBoyNo, String description) {
		this.parkingBoyNo = parkingBoyNo;
		this.description = description;
	}
	public String getParkingBoyNo() {
		return parkingBoyNo;
	}

	public String getDescription() {
		return description;
	}
}
