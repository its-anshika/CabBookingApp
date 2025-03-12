package com.example.CabBooking.model;

//import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

//@Getter
public class Cab {
    String id;
    String riderName;
    @Setter
    Trip currentTrip;
    @Setter
    Location currentLocation;
    @Setter
    Boolean isAvailable;

    public Cab(String id, String riderName) {
        this.id = id;
        this.riderName = riderName;
        this.isAvailable = true;
    }
    public String getCabId(){
        return this.id;
    }
    public Trip getCurrentTripOfCab(){
        return this.currentTrip;
    }
    public void setCurrentLocationOfCab(Location newLocation){
        this.currentLocation = newLocation;
    }
    public void setIsAvailableOfCab(Boolean newAvailable){
        this.isAvailable = newAvailable;
    }
    public void setCurrentTripOfCab(Trip currTrip){
        this.currentTrip = currTrip;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + riderName + '\'' +
                ", currentLocation=" + currentLocation +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
