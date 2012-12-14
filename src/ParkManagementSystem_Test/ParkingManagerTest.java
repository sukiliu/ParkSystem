package ParkManagementSystem_Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ParkManagementSystem.Car;
import ParkManagementSystem.MaxAvailableParkingLotChooser;
import ParkManagementSystem.ParkPlace;
import ParkManagementSystem.ParkingBoy;
import ParkManagementSystem.ParkingManager;

public class ParkingManagerTest {
	private Integer totalAmount;
	private ParkingManager pManager;
	private List<ParkingBoy> parkingBoyList ;
	private List<ParkPlace> parkPlacesList ;

	@Before
	public void init() {
		List<ParkPlace> parkPlaces_S = new ArrayList<ParkPlace>();
		Integer[] parkPlaceNums = new Integer[] { 10, 20 };
		totalAmount = 0;
		for (Integer parknum : parkPlaceNums) {
			parkPlaces_S.add(new ParkPlace(parknum));
			totalAmount += parknum;
		}
		ParkingBoy smartparkingBoy = new ParkingBoy(parkPlaces_S,
				new MaxAvailableParkingLotChooser());
		this.parkingBoyList.add(smartparkingBoy);
		for (int j = 0; j < parkPlaces_S.size(); j++) {
			this.parkPlacesList.add(parkPlaces_S.get(j));
		}
	}

	/*
	 * 有空车位，Manager自己随机停车。
	 */
	@Test
	public void Manager_Personally_park_Sucess_when_park_is_empty() {
		pManager = new ParkingManager(parkingBoyList, parkPlacesList);
		Car car = new Car();
		pManager.parking(car);

	}

	/*
	 * 都空 取车
	 */
	@Test
	public void should_fetch_faild_when_park_is_empty() {
		/*
		 * 未测试
		 */
	}

	/*
	 * 不全为空 ,取车
	 */
	@Test
	public void should_fetch_Sucess_when_park_is_notempty() {
		/*
		 * 未测试
		 */
	}

	/*
	 * 有空车位，Manager让smartParkingBoy停车。
	 */
	@Test
	public void Manager_let_parkingBoy_park_Sucess_when_park_is_empty() {
		ParkingManager pManager = new ParkingManager(parkingBoyList,parkPlacesList);
		Car c = new Car();
		ParkingBoy pBoy = parkingBoyList.get(0);
		for (int i = 0; parkingBoyList.get(i).toString() == "SmartParkingBoy"; i++) {
			pBoy = parkingBoyList.get(i);
		}
		pManager.parking(c, pBoy);
		Assert.assertEquals(new Integer(totalAmount - 1),
				pBoy.getAvailableNum());
	}

}
