package ParkManagementSystem_Test;

import ParkManagementSystem.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class superparkingboyTest {

	private Integer totalAmount;
	private ParkingBoy parkingBoy;
	private List<ParkPlace> parkPlaces;

	@Before
	public void init() {
		List<ParkPlace> parkPlaces = new ArrayList<ParkPlace>();
		Integer[] parkPlaceNums = new Integer[] { 10, 20 };
		totalAmount = 0;
		for (Integer parknum : parkPlaceNums) {
			parkPlaces.add(new ParkPlace(parknum));
			totalAmount += parknum;
		}
		parkingBoy = new ParkingBoy(parkPlaces, new MaxVacancyRateLotChooser());
		this.parkPlaces = parkPlaces;
	}

	/*
	 * 都空 停车
	 */
	@Test
	public void should_park_Sucess_when_park_is_empty() {
		parkingBoy.park(new Car());
		Assert.assertEquals(new Integer(totalAmount - 1),
				parkingBoy.getAvailableNum());
	}

	/*
	 * 都空 取车
	 */
	@Test(expected = NoCarException.class)
	public void should_fetch_faild_when_park_is_empty() {
		parkingBoy.fetch(new Ticket());
	}

	/*
	 *  不全为空 ,取车
	 */
	@Test
	public void should_fetch_Sucess_when_park_is_notempty() {
		for (int i = 0; i < totalAmount / 2; i++) {
			parkingBoy.park(new Car());
		}
		Car car = new Car();
		Ticket ticket = parkingBoy.park(car);
		Assert.assertSame(car,parkingBoy.fetch(ticket));
	}

	/*
	 * 全满 ,停车
	 */
	@Test(expected = NoPlaceException.class)
	public void should_throwParkFullException_if_park_when_park_is_full() {
		for (int i = 0; i < totalAmount; i++) {
			parkingBoy.park(new Car());
		}
		parkingBoy.park(new Car());
	}

	/*
	 * Super Parking Boy测试 停车停在空置率大的那个停车场
	 */

	@Test	
	public void should_park_in_the_more_VacancyRate_parkplace() {
		for (int i = 1; i <= 10; i++) {
			parkingBoy.park(new Car());
		}//此时第一个停车场空置率<第二个停车场空置率。
		Assert.assertEquals((Integer)6 , parkPlaces.get(0).GetAvailableNum());
		Assert.assertEquals((Integer)14 , parkPlaces.get(1).GetAvailableNum());
		Assert.assertEquals(true , parkPlaces.get(0).GetVacancyRate()< parkPlaces.get(1).GetVacancyRate());
		parkingBoy.park(new Car());
		Assert.assertEquals((Integer)6 , parkPlaces.get(0).GetAvailableNum());
		Assert.assertEquals((Integer)13 , parkPlaces.get(1).GetAvailableNum());
		
	}

	/*
	 * Super Parking Boy测试 两个车库空置率相同时停在第一个
	 */
	
	@Test
	public void should_park_in_the_first_parkplace_if_all_park_VacancyRate_same() {
		for (int i = 1; i <= 15; i++) {
			parkingBoy.park(new Car());
		}//此时两个停车场空置率都为50%。
		Assert.assertEquals((Integer)5 , parkPlaces.get(0).GetAvailableNum());
		Assert.assertEquals((Integer)10 , parkPlaces.get(1).GetAvailableNum());
		parkingBoy.park(new Car());
		Assert.assertEquals((Integer)4 , parkPlaces.get(0).GetAvailableNum());
		Assert.assertEquals((Integer)10 , parkPlaces.get(1).GetAvailableNum());
	}
}
