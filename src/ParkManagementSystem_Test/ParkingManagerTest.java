package ParkManagementSystem_Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ParkManagementSystem.Car;
import ParkManagementSystem.MaxAvailableParkingLotChooser;
import ParkManagementSystem.NoCarException;
import ParkManagementSystem.ParkPlace;
import ParkManagementSystem.ParkingBoy;
import ParkManagementSystem.ParkingBoys;
import ParkManagementSystem.ParkingManager;
import ParkManagementSystem.Ticket;

public class ParkingManagerTest {
	ParkingManager pManager = new ParkingManager();
	int totalCapacity;

	/*
	 * 有停车场经理pManager，他管理着两个停车场编号为03 和09以及三个停车仔编号为parkingBoy001，parkingBoy002和parkingBoy003。
	 * 其中parkingBoy001管理着两个停车场编号为01和02，采用最多空车位停车；
	 * parkingBoy002管理着三个停车场编号为04和05，采用最高空置率停车；
	 * parkingBoy003管理着两个停车场编号为06，07和08，采用顺序优先停车。
	 */
	@Before
	public void init() {

		List<ParkPlace> parkPlaces_smart = new ArrayList<ParkPlace>();
		parkPlaces_smart.add(new ParkPlace("01", 10));
		parkPlaces_smart.add(new ParkPlace("02", 20));
		ParkingBoys parkingBoys_smart = new ParkingBoys(parkPlaces_smart,
				new MaxAvailableParkingLotChooser());
		ParkingBoy parkingBoy_smart = new ParkingBoy("parkingBoy001", "smartBoy");
		pManager.addParkBoy(parkingBoy_smart, parkingBoys_smart);

		pManager.addParkPlace("03", true, 10);

		List<ParkPlace> parkPlaces_super = new ArrayList<ParkPlace>();
		parkPlaces_super.add(new ParkPlace("04", 15));
		parkPlaces_super.add(new ParkPlace("05", 10));
		ParkingBoys parkingBoys_super = new ParkingBoys(parkPlaces_super,
				new MaxAvailableParkingLotChooser());
		ParkingBoy parkingBoy_super = new ParkingBoy("parkingBoy002", "superBoy");
		pManager.addParkBoy(parkingBoy_super, parkingBoys_super);

		List<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
		parkPlaces_super.add(new ParkPlace("06", 5));
		parkPlaces_super.add(new ParkPlace("07", 15));
		parkPlaces_super.add(new ParkPlace("08", 10));
		ParkingBoys parkingBoys = new ParkingBoys(parkPlaces,
				new MaxAvailableParkingLotChooser());
		ParkingBoy parkingBoy = new ParkingBoy("parkingBoy003", "parkBoy");
		pManager.addParkBoy(parkingBoy, parkingBoys);

		pManager.addParkPlace("09", true, 15);
		
		totalCapacity =pManager.allManageTotalCapacity();

	}

	/*
	 * 有空车位，Manager自己随机停车。
	 */
	@Test
	public void Manager_Personally_park_Sucess_when_park_is_empty() {
		Car c = new Car();
		pManager.parking(c);
		Assert.assertEquals(new Integer(totalCapacity - 1),pManager.allManageAvailableNum());
	}

	/*
	 * 都空 取车
	 */
	@Test (expected = NoCarException.class)
	public void should_fetch_faild_when_park_is_empty() {
		pManager.fetch(new Ticket());
	}

	/*
	 * 不全为空 ,取车
	 */
	@Test (expected = NoCarException.class)
	public void should_fetch_Sucess_when_park_is_notempty() {
		for (int i = 0; i <7; i++) {
			pManager.parking(new Car());
		}
		Car car = new Car();
		Ticket ticket = pManager.parking(car);
		Assert.assertSame(car,pManager.fetch(ticket));
	}

	/*
	 * 有空车位，Manager让smartParkingBoy停车。
	 */
	@Test
	public void Manager_let_parkingBoy_park_Sucess_when_park_is_empty() {
		for (int i = 0; i <5; i++) {
			pManager.parking(new Car());
		}
		ParkingBoy smartparkingBoy=pManager.getParkBoys("parkingBoy001") ;
		
		pManager.parking(new Car(),smartparkingBoy);
		Assert.assertEquals(new Integer(totalCapacity-6), pManager.allManageAvailableNum());
	}

}
