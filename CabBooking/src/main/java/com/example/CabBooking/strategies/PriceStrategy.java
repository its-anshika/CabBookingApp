package com.example.CabBooking.strategies;

import com.example.CabBooking.model.Location;
import org.springframework.stereotype.Service;

@Service
public interface PriceStrategy {
    public Double calcPrice(Location from, Location to);

}
