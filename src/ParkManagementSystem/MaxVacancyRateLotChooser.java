package ParkManagementSystem;

import java.util.List;

public class MaxVacancyRateLotChooser implements ParkingLotChooser {
	public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        int maxsizeIndex=0;
		for(int i=1;i< parkPlaceList.size();i++){
            if(parkPlaceList.get(i).GetVacancyRate()> parkPlaceList.get(maxsizeIndex).GetVacancyRate())
                maxsizeIndex=i;
        }
        if(parkPlaceList.get(maxsizeIndex).GetAvailableNum()==0)throw new NoPlaceException("所有的停车场都已满");
        return   parkPlaceList.get(maxsizeIndex);
    }
}
