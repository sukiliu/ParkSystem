package ParkManagementSystem;

import java.util.List;
import java.util.Random;

public class ParkingManager {
	protected List<ParkingBoy> parkingBoyList;
	protected ParkingBoy pBoy;
	protected List<ParkPlace> parkplaceList;

	public ParkingManager(List<ParkingBoy> parkingBoyList,
			List<ParkPlace> parkPlacesList) {
		this.parkingBoyList = parkingBoyList;
		this.parkplaceList = parkPlacesList;
	}

	public Ticket parking(Car c) {
		int rd=new Random().nextInt(10);
		int i=rd%3;
		ParkPlace p;
		try {
			p = parkplaceList.get(i);
		} catch (Exception e) {
			p = parkplaceList.get(0);
		}
		return p.parking(c);
	}

	public Ticket parking(Car c, ParkingBoy pBoy) {
		return pBoy.park(c);
	}
}
