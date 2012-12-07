package ParkManagementSystem;

public class SmartParkingBoy extends ParkingBoy {
    public SmartParkingBoy(int p1, int p2) {
        super(p1, p2);
    }
    public void selectParkPlace(){
        if (parkPlace_1.GetAvailableNum()>=parkPlace_2.GetAvailableNum()){
            _parkPlace =parkPlace_1;
        }
        else _parkPlace =parkPlace_2;
    }
}
