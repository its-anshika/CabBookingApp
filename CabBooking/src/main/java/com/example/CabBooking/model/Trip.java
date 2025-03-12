package com.example.CabBooking.model;

import lombok.ToString;

@ToString
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus status;
    private Double price;
    private Location fromPoint;
    private Location toPoint;

    public Trip(Rider rider, Cab cab, Double price, Location x, Location y){
        this.rider = rider;
        this.cab = cab;
        this.status = TripStatus.Started;
        this.price = price;
        this.fromPoint = x;
        this.toPoint = y;
    }

    public void endTrip(){
        this.status = TripStatus.Finished;
    }
}
