package ParkManagementSystem;

import java.util.List;

public class ParkingManager {
	protected List<ParkingBoy> parkingBoy;
    private final ChooseWhoParking whoparkingLotChooser;

    public ParkingManager(List<ParkingBoy> parkingBoy, ChooseWhoParking choosewhoparking) {
        this.parkingBoy=parkingBoy;
        this.whoparkingLotChooser = choosewhoparking;
    }
	public Ticket parking(Car c) {
		ParkPlace p=new ParkPlace(90);
		return p.parking(c);		
	}

}
