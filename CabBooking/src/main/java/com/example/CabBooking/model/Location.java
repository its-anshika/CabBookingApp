package com.example.CabBooking.model;

import lombok.AllArgsConstructor;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

//@AllArgsConstructor
public class Location {
    private Double x;
    private Double y;
    public Location(Double x, Double y){
        this.x = x;
        this.y = y;
    }
    public Double distance(Location l){

        return sqrt(pow(this.x - l.x,2) + pow(this.y - l.y, 2));
    }

}
