package ParkManagementSystem_Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ParkManagementSystem.Car;
import ParkManagementSystem.MaxAvailableParkingLotChooser;
import ParkManagementSystem.ParkPlace;
import ParkManagementSystem.ParkingBoy;
import ParkManagementSystem.ParkingManager;
import ParkManagementSystem.chooseselbst;


public class ParkingManagerTest {
	private Integer totalAmount;
	private List<ParkingBoy> parkingBoy;
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
		parkingBoy.add(new ParkingBoy(parkPlaces,new MaxAvailableParkingLotChooser()));

		this.parkPlaces = parkPlaces;
	}
	/*	
	 * 有空车位，Manager自己随机停车。
	*/
	@Test
	public void Manager_Personally_park_Sucess_when_park_is_empty() {
	ParkingManager pManager= new ParkingManager(parkingBoy,new chooseselbst());
	Car car=new Car();
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
	 *  不全为空 ,取车
	*/
	@Test
	public void should_fetch_Sucess_when_park_is_notempty() {
		/*
		 * 未测试
		*/
	}
	
	/*	
	 * 有空车位，Manager让ParkingBoy停车。
	*/
	@Test
	public void Manager_let_parkingBoy_park_Sucess_when_park_is_empty() {
	/*
	 * 未测试
	*/
	}
	
}
