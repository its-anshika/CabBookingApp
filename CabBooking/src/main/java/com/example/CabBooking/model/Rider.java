package com.example.CabBooking.model;

import com.example.CabBooking.database.RidersRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor
public class Rider {
    String id;
    String riderName;
    public Rider(String id, String riderName) {
        this.id = id;
        this.riderName = riderName;
    }
    public String getRiderId(){
        return this.id;
    }

}
