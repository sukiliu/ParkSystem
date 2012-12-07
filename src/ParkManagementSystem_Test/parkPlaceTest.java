package ParkManagementSystem_Test;

import org.junit.Assert;
import org.junit.Test;
import ParkManagementSystem.*;


public class parkPlaceTest {

    @Test
    public void parkPlace_Parking_HavePlace(){
        ParkPlace  PP = new  ParkPlace(20);
        Car C = new Car();
        Ticket proof = PP.parking(C) ;
        Assert.assertNotNull(proof);
    }

    @Test ( expected = NoPlaceException.class)
    public void parkPlace_Parking_NoPlace()   {
        ParkPlace  PP = new  ParkPlace(1);
        PP.parking( new Car()) ;
        Ticket proof = PP.parking( new Car()) ;
        Assert.assertFalse(true);
    }

    @Test
    public void parkPlace_GetCar(){

        ParkPlace  PP = new  ParkPlace(20);
        Car car = new Car();
        Ticket proof =  PP.parking(car) ;

        Assert.assertSame(car, PP.GetParkedCar(proof));

    }
    @Test    ( expected = NoCarException.class)
    public void parkPlace_GetCar_NoThisCar() {

        ParkPlace  PP = new  ParkPlace(20);
        Ticket proof =  PP.parking( new Car()) ;
        PP.GetParkedCar(proof);

        PP.GetParkedCar(proof);

    }
    @Test
    public void parkPlace_ShowAvailableNum()  {
        int maxParkingNum = 20;
        ParkPlace  PP = new  ParkPlace(maxParkingNum);
        PP.parking( new Car()) ;
        PP.parking( new Car()) ;
        Assert.assertEquals(Integer.valueOf(maxParkingNum-2),PP.GetAvailableNum());
    }
     @Test
    public void ParkingBoy_Parking_ParkPlace1_HavePlace(){
        ParkingBoy parkingBoy =new ParkingBoy(20,30);
         Car C = new Car();
         parkingBoy.parking(C);
         Ticket proof = parkingBoy.ticket;
         Assert.assertNotNull(proof);
         Assert.assertEquals((Integer)19,parkingBoy.parkPlace_1.GetAvailableNum());
     }
    @Test
    public void ParkingBoy_Parking_ParkPlace1_NOPlace(){
        ParkingBoy parkingBoy =new ParkingBoy(0,30);
        Car C = new Car();
        parkingBoy.parking(C);
        Ticket proof = parkingBoy.ticket;
        Assert.assertNotNull(proof);
        Assert.assertEquals((Integer)29,parkingBoy.parkPlace_2.GetAvailableNum());
    }
    @Test ( expected = NoPlaceException.class)
    public void ParkingBoy_Parking_AllParkPlace_NOPlace(){
        ParkingBoy parkingBoy =new ParkingBoy(0,0);
        Car C =new Car();
        parkingBoy.parking(C);
        Assert.assertEquals((Integer)0,parkingBoy.parkPlace_1.GetAvailableNum());
        Assert.assertEquals((Integer)0,parkingBoy.parkPlace_2.GetAvailableNum());
    }
    @Test
    public void SmartParkingBoy_Parking_ParkPlace1_Less_than_ParkPlace2(){
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(20,30);
        Car C=new Car();
        smartParkingBoy.parking(C);
        Assert.assertEquals((Integer)20,smartParkingBoy.parkPlace_1.GetAvailableNum());
        Assert.assertEquals((Integer)29,smartParkingBoy.parkPlace_2.GetAvailableNum());
    }
    public void SmartParkingBoy_Parking_ParkPlace1_VacancyRate_Less_than_ParkPlace2(){
        SuperParkingBoy superParkingBoy = new SuperParkingBoy(7,3);
        Car C=new Car();
        superParkingBoy.parking(C);
        Assert.assertEquals((Integer) 20, superParkingBoy.parkPlace_1.GetAvailableNum());
        Assert.assertEquals((Integer)29,superParkingBoy.parkPlace_2.GetAvailableNum());
    }
}
