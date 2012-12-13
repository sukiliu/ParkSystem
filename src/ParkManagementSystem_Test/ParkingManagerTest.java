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
	 * �пճ�λ��Manager�Լ����ͣ����
	*/
	@Test
	public void Manager_Personally_park_Sucess_when_park_is_empty() {
	ParkingManager pManager= new ParkingManager(parkingBoy,new chooseselbst());
	Car car=new Car();
	pManager.parking(car);
	
	}
	
	/*
	 * ���� ȡ��
	*/
	@Test
	public void should_fetch_faild_when_park_is_empty() {
		/*
		 * δ����
		*/
	}

	/*
	 *  ��ȫΪ�� ,ȡ��
	*/
	@Test
	public void should_fetch_Sucess_when_park_is_notempty() {
		/*
		 * δ����
		*/
	}
	
	/*	
	 * �пճ�λ��Manager��ParkingBoyͣ����
	*/
	@Test
	public void Manager_let_parkingBoy_park_Sucess_when_park_is_empty() {
	/*
	 * δ����
	*/
	}
	
}
