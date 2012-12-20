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
	 * ��ͣ��������pManager��������������ͣ�������Ϊ03 ��09�Լ�����ͣ���б��ΪparkingBoy001��parkingBoy002��parkingBoy003��
	 * ����parkingBoy001����������ͣ�������Ϊ01��02���������ճ�λͣ����
	 * parkingBoy002����������ͣ�������Ϊ04��05��������߿�����ͣ����
	 * parkingBoy003����������ͣ�������Ϊ06��07��08������˳������ͣ����
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
	 * �пճ�λ��Manager�Լ����ͣ����
	 */
	@Test
	public void Manager_Personally_park_Sucess_when_park_is_empty() {
		Car c = new Car();
		pManager.parking(c);
		Assert.assertEquals(new Integer(totalCapacity - 1),pManager.allManageAvailableNum());
	}

	/*
	 * ���� ȡ��
	 */
	@Test (expected = NoCarException.class)
	public void should_fetch_faild_when_park_is_empty() {
		pManager.fetch(new Ticket());
	}

	/*
	 * ��ȫΪ�� ,ȡ��
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
	 * �пճ�λ��Manager��smartParkingBoyͣ����
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
