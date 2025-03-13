package com.example.CabBooking.model;

//import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

//@Getter
public class Cab {
    String id;
    String driverName;
    @Setter
    Trip currentTrip;
    @Setter
    Location currentLocation;
    @Setter
    Boolean isAvailable;

    public Cab(String id, String driverName) {
        this.id = id;
        this.driverName = driverName;
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
    public Location getCurrentLocationOfCab(){
        return this.currentLocation;
    }

    public void setIsAvailableOfCab(Boolean newAvailable){
        this.isAvailable = newAvailable;
    }
    public Boolean getIsAvailableOfCab(){
        return this.isAvailable;
    }

    public void setCurrentTripOfCab(Trip currTrip){
        this.currentTrip = currTrip;
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id='" + id + '\'' +
                ", driverName='" + driverName + '\'' +
                ", currentLocation=" + currentLocation +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
