package com.example.CabBooking.strategies;

import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Rider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CabAssigningStrategy {
    public Cab selectCab(Rider rider, List<Cab> availableCabs);
}
