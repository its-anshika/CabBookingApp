package com.example.CabBooking.database;

import com.example.CabBooking.exceptions.TripNotFoundException;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Trip;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TripsRepository {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    private Map<String, List<Trip>> trips = new HashMap<>();

    private CabsRepository cabsRepository;
    private RidersRepository ridersRepository;

    public void endTrip(Cab cab){
        if (cab.getCurrentTripOfCab() == null) {
            throw new TripNotFoundException();
        }
        cab.getCurrentTripOfCab().endTrip();
        cab.setCurrentTripOfCab(null);
    }
}
