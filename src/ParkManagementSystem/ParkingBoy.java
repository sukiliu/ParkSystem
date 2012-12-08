package ParkManagementSystem;

import java.util.List;


public class ParkingBoy {
	protected List<ParkPlace> parkPlaces;
    private final ParkingLotChooser parkingLotChooser;

    public ParkingBoy(List<ParkPlace> parkPlaces, ParkingLotChooser parkingLotChooser) {
        this.parkPlaces=parkPlaces;
        this.parkingLotChooser = parkingLotChooser;
    }
    public Ticket park(Car car) {
      return parkingLotChooser.getAvailablePark(parkPlaces).parking(car);
    }

    public Integer getAvailableNum() {
        int availableNum=0;
        for(ParkPlace parkPlace:parkPlaces){
            availableNum+=parkPlace.GetAvailableNum();
        }
       return availableNum;
    }
    public Car fetch(Ticket ticket) {
        Car fetchedCar=null;
        for(ParkPlace parkPlace:parkPlaces){
            fetchedCar=parkPlace.fetchCar(ticket);
            if(fetchedCar!=null){return fetchedCar;}
        }
        throw new NoCarException("没有此车");
    }
}

