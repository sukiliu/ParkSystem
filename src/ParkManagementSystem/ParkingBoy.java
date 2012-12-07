package ParkManagementSystem;


public class ParkingBoy {
    public ParkPlace parkPlace_1;
    public ParkPlace parkPlace_2;
    protected ParkPlace _parkPlace;
    public  Ticket ticket;
    public ParkingBoy(int p1,int p2){
       parkPlace_1=new ParkPlace(p1);
       parkPlace_2=new ParkPlace(p2);
    }

    public void selectParkPlace(){
        if (parkPlace_1.GetAvailableNum()>0){
            _parkPlace =parkPlace_1;
        }
        else _parkPlace =parkPlace_2;
    }
    public void parking(Car c) {
        selectParkPlace();
        ticket= _parkPlace.parking(c);
    }
   public void getCar(Ticket ppT){
       Car car=null;
       ParkPlace parkPlace = new ParkPlace();
       car = parkPlace.GetParkedCar(ticket);
       }
}


