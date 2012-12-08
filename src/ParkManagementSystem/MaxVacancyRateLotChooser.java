package ParkManagementSystem;

import java.util.List;

public class MaxVacancyRateLotChooser implements ParkingLotChooser {
	public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList) {
        int maxsizeIndex=0;
		for(int i=1;i< parkPlaceList.size();i++){
            if(parkPlaceList.get(i).GetVacancyRate()> parkPlaceList.get(maxsizeIndex).GetVacancyRate())
                maxsizeIndex=i;
        }
        if(parkPlaceList.get(maxsizeIndex).GetAvailableNum()==0)throw new NoPlaceException("���е�ͣ����������");
        return   parkPlaceList.get(maxsizeIndex);
    }
}
