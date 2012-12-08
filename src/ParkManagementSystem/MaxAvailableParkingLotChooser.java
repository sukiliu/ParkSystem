package ParkManagementSystem;

import java.util.List;

public class MaxAvailableParkingLotChooser implements ParkingLotChooser{
    public ParkPlace getAvailablePark(List<ParkPlace> parkPlaceList){
        int maxsizeIndex=0;
        for(int i=1;i< parkPlaceList.size();i++){
            if(parkPlaceList.get(i).GetAvailableNum()> parkPlaceList.get(maxsizeIndex).GetAvailableNum())
                maxsizeIndex=i;
        }
        if(parkPlaceList.get(maxsizeIndex).GetAvailableNum()==0)throw new NoPlaceException("���е�ͣ����������");
        return   parkPlaceList.get(maxsizeIndex);
    }
}
