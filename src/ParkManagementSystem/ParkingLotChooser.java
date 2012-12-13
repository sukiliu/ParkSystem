package ParkManagementSystem;

import java.util.List;

public interface ParkingLotChooser {
    ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList);
}
 