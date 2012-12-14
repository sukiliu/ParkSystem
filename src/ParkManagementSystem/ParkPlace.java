package ParkManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkPlace {
	private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
	private Integer maxParkingNum;

	public Integer GetAvailableNum() {
		return maxParkingNum - parkedCarList.size();
	}

	public Double GetVacancyRate() {
		return GetAvailableNum().doubleValue() / maxParkingNum.doubleValue();
	}

	public ParkPlace(int maxParkingNum) {
		this.maxParkingNum = maxParkingNum;
	}

	public Ticket parking(Car c) throws NoPlaceException {
		if (GetAvailableNum() == 0) {
			throw new NoPlaceException("ͣ��������");
		}
		Ticket ticket = new Ticket();
		parkedCarList.put(ticket, c);
		return ticket;
	}

	public Car fetchCar(Ticket ppT) throws NoCarException {
		if (parkedCarList.containsKey(ppT)) {
			return parkedCarList.remove(ppT);
		}
		throw new NoCarException("û�д˳�");
	}
}
