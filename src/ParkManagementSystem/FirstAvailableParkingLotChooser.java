package ParkManagementSystem;

import java.util.List;

public class FirstAvailableParkingLotChooser implements ParkingLotChooser {
    @Override
    public ParkPlaces getAvailablePark(List<ParkPlace> parkPlaceList){
        for(ParkPlaces parkPlace:parkPlaceList){
            if(parkPlace.GetAvailableNum()>0) return parkPlace;
        }
        throw new NoPlaceException("所有的停车场都已满");
    }
}
