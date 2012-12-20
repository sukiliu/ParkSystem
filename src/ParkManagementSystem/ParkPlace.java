package ParkManagementSystem;

public class ParkPlace extends ParkPlaces {
    private String parkPlaceNo="";
    private boolean isManager= false;

    public ParkPlace(String parkPlaceNo,boolean isManager,int capacity) {
    	super(capacity);
        this.isManager= isManager;
        this.parkPlaceNo = parkPlaceNo;
    }
    public ParkPlace(String parkPlaceNo,int capacity) {
    	super(capacity);
        this.parkPlaceNo = parkPlaceNo;
    }
    public String getParkPlaceNo() {
        return parkPlaceNo;
    }

    public void setParkPlaceNo(String parkPlaceNo) {
        this.parkPlaceNo = parkPlaceNo;
    }

    public boolean getisManager() {
        return isManager;
    }

}
