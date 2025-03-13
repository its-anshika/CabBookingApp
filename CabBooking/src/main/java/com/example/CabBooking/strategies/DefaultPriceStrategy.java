package com.example.CabBooking.strategies;

import com.example.CabBooking.model.Location;
import org.springframework.stereotype.Service;

@Service
public class DefaultPriceStrategy implements PriceStrategy{
    public static final Double PRICE_PER_KM = 15.0;

    @Override
    public Double calcPrice(Location from, Location to){
        return from.distance(to) * PRICE_PER_KM;
    }
}
