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
        Assert.assertNull(proof);
        Assert.assertFalse(true);
    }

    @Test
    public void parkPlace_GetCar(){
        ParkPlace  PP = new  ParkPlace(20);
        Car car = new Car();
        Ticket proof =  PP.parking(car) ;
        Assert.assertSame(car, PP.fetchCar(proof));
    }
    @Test    ( expected = NoCarException.class)
    public void parkPlace_GetCar_NoThisCar() {

        ParkPlace  PP = new  ParkPlace(20);
        Ticket proof =  PP.parking( new Car()) ;
        PP.fetchCar(proof);
        PP.fetchCar(proof);
    }
    @Test
    public void parkPlace_ShowAvailableNum()  {
        int maxParkingNum = 20;
        ParkPlace  PP = new  ParkPlace(maxParkingNum);
        PP.parking( new Car()) ;
        PP.parking( new Car()) ;
        Assert.assertEquals(Integer.valueOf(maxParkingNum-2),PP.GetAvailableNum());
    }
}
