package ParkManagementSystem;

import java.util.HashMap;
import java.util.Map;

public class ParkPlaces {
	private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
	protected Integer maxParkingNum;
	

	public Integer getMaxParkingNum() {
		return maxParkingNum;
	}

	public Integer GetAvailableNum() {
		return maxParkingNum - parkedCarList.size();
	}

	public Double GetVacancyRate() {
		return GetAvailableNum().doubleValue() / maxParkingNum.doubleValue();
	}

	public ParkPlaces(int maxParkingNum) {
		this.maxParkingNum = maxParkingNum;
	}

	public Ticket parking(Car c) throws NoPlaceException {
		if (GetAvailableNum() == 0) {
			throw new NoPlaceException("停车场已满");
		}
		Ticket ticket = new Ticket();
		parkedCarList.put(ticket, c);
		return ticket;
	}

	public Car fetchCar(Ticket ppT) throws NoCarException {
		if (parkedCarList.containsKey(ppT)) {
			return parkedCarList.remove(ppT);
		}
		throw new NoCarException("没有此车");
	}
}
