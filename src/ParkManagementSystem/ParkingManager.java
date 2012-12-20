package ParkManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ParkingManager {
	protected List<ParkPlace> parkplaceList =new ArrayList<ParkPlace>();
	protected Map<ParkingBoy, ParkingBoys> parkingBoyMap = new HashMap<ParkingBoy, ParkingBoys>();

	public void addParkBoy(ParkingBoy parkingBoy, ParkingBoys parkingBoys) {
		this.parkingBoyMap.put(parkingBoy, parkingBoys);
		for (int i = 0; i < parkingBoys.getParkPlaces().size(); i++) {
			this.parkplaceList.add(parkingBoys.getParkPlaces().get(i));
		}
	}

	public void addParkPlace(String parkPlaceNo, boolean isManager, int capacity) {
		this.parkplaceList.add(new ParkPlace(parkPlaceNo, isManager, capacity));
	}

	public ParkingBoy getParkBoys(String parkingBoyNo) {
		ParkingBoy parkingBoy = null;
		Set<ParkingBoy> keySet = parkingBoyMap.keySet();
		for (ParkingBoy pBoy : keySet) {
			if (pBoy.getParkingBoyNo() == parkingBoyNo) {
				parkingBoy = pBoy;
			}
		}
		return parkingBoy;
	}

	public Map<ParkingBoy, ParkingBoys> getParkBoyMap() {
		return parkingBoyMap;
	}

	public Integer allManageTotalCapacity() {
		Integer allManageTotalCapacity = 0;
		for (int i = 0; i < parkplaceList.size(); i++) {
			allManageTotalCapacity += parkplaceList.get(i).getMaxParkingNum();
		}
		return allManageTotalCapacity;
	}

	public Integer allManageAvailableNum() {
		Integer allManageAvailableNum = 0;
		for (int i = 0; i < parkplaceList.size(); i++) {
			allManageAvailableNum += parkplaceList.get(i).GetAvailableNum();
		}
		return allManageAvailableNum;
	}

	public Ticket parking(Car c) {
		int rd = new Random().nextInt(parkplaceList.size());
		if (allManageAvailableNum() == 0) {
			throw new NoPlaceException("没有空车位！");
		}
		while (parkplaceList.get(rd).GetAvailableNum() == 0) {
			rd = new Random().nextInt(parkplaceList.size());
		}
		return parkplaceList.get(rd).parking(c);
	}

	public Ticket parking(Car c, ParkingBoy pBoy) {
		return parkingBoyMap.get(pBoy).park(c);
	}

	public Car fetch(Ticket ticket) {
		Car fetchedCar = null;
		for (ParkPlaces parkPlace : parkplaceList) {
			fetchedCar = parkPlace.fetchCar(ticket);
			if (fetchedCar != null) {
				return fetchedCar;
			}
		}
		throw new NoCarException("没有此车");
	}

	public void showParkingManagerReporter() {

		if (parkplaceList.isEmpty())
			System.out.println("无所属停车仔，也没有自属停车场。");
		else {
			System.out.println("主管报表:");
			for (ParkPlace parkPlace : parkplaceList) {
				if (parkPlace.getisManager()) {
					System.out.println("停车场编号：" + parkPlace.getParkPlaceNo());
					System.out.println("\t车位数：" + parkPlace.getMaxParkingNum());
					System.out.println("\t空位数：" + parkPlace.GetAvailableNum());
				}
			}
			showParkingBoyReporter();
		}
		System.out.println("Total车位数：" + allManageTotalCapacity());
		System.out.println("Total空位数：" + allManageAvailableNum());
	}

	public void showParkingBoyReporter() {
		Integer allTotalCapacity = 0, allAvailableNum = 0;
		if (parkingBoyMap.isEmpty()) {
			System.out.println("\n");
		} else {
			Set<ParkingBoy> keySet = parkingBoyMap.keySet();
			for (ParkingBoy pBoy : keySet) {
				System.out.println("\t\b停车仔 编号：" + pBoy.getParkingBoyNo());
				for (ParkPlace parkPlace : parkingBoyMap.get(pBoy)
						.getParkPlaces()) {
					System.out.println("\t\t停车场编号："
							+ parkPlace.getParkPlaceNo());
					System.out.println("\t\t\b车位数："
							+ parkPlace.getMaxParkingNum());
					System.out.println("\t\t\b空位数："
							+ parkPlace.GetAvailableNum());
					allAvailableNum += parkPlace.getMaxParkingNum();
					allAvailableNum += parkPlace.GetAvailableNum();
				}
				System.out.println("\t\b所属停车场Total车位数：" + allTotalCapacity);
				System.out.println("\t\b所属停车场Total空位数：" + allAvailableNum);
			}
		}
	}
}
