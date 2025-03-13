package com.example.CabBooking.strategies;

import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Rider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCabAssignStrategy implements CabAssigningStrategy {

    @Override
    public Cab selectCab(Rider rider, List<Cab> availableCabs) {
        return availableCabs.get(0);//first available cab
    }
}
