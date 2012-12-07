package ParkManagementSystem;

public class SuperParkingBoy extends ParkingBoy {
    public SuperParkingBoy(int p1, int p2) {
        super(p1, p2);
    }
    public void selectParkPlace(){
        if (parkPlace_1.GetVacancyRate()>=parkPlace_2.GetVacancyRate()){
            _parkPlace =parkPlace_1;
        }
        else _parkPlace =parkPlace_2;
    }
}
