package ParkManagementSystem;

import java.util.List;

public interface ParkingLotChooser {
    ParkPlaces getAvailablePark(List<ParkPlace> parkPlaceList);
}
 