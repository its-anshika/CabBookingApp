package com.example.CabBooking.database;

import com.example.CabBooking.exceptions.NoCabsNearbyException;
import com.example.CabBooking.exceptions.TripNotFoundException;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Location;
import com.example.CabBooking.model.Rider;
import com.example.CabBooking.model.Trip;
import com.example.CabBooking.strategies.CabAssigningStrategy;
import com.example.CabBooking.strategies.PriceStrategy;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TripsRepository {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 30.0;
    private final Map<String, List<Trip>> trips = new HashMap<>();//riderId, trips list

    private final CabsRepository cabsRepository;
    private final RidersRepository ridersRepository;
    private final PriceStrategy priceStrategy;
    private final CabAssigningStrategy cabAssigningStrategy;

    @Autowired
    public TripsRepository( CabsRepository cabsRepository, RidersRepository ridersRepository,PriceStrategy priceStrategy, CabAssigningStrategy cabAssigningStrategy){
        this.cabsRepository = cabsRepository;
        this.ridersRepository = ridersRepository;
        this.cabAssigningStrategy = cabAssigningStrategy;
        this.priceStrategy = priceStrategy;
    }

//    public void createTrip(Rider rider, Location source, Location destination){
public void createTrip(
        @NonNull final Rider rider,
        @NonNull final Location fromPoint,
        @NonNull final Location toPoint) {
        List<Cab> nearbyCabs = cabsRepository.getCabs(fromPoint, MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
        if(nearbyCabs.isEmpty())
            throw new NoCabsNearbyException("No Cabs found nearby!");
        Cab assignedCab = cabAssigningStrategy.selectCab(rider, nearbyCabs);
        if (assignedCab == null) {
            throw new NoCabsNearbyException("No Cabs found nearby!");
        }
        final Double price = priceStrategy.calcPrice(fromPoint, toPoint);
        final Trip currTrip = new Trip(rider, assignedCab, price,fromPoint, toPoint);
        if(!trips.containsKey(rider.getRiderId()))
            trips.put(rider.getRiderId(), new ArrayList<>());
        trips.get(rider.getRiderId()).add(currTrip);
        assignedCab.setCurrentTripOfCab(currTrip);
    }
    public List<Trip> getHistory(@NonNull String riderId){
        return trips.get(riderId);
    }

    public void endTrip(@NonNull Cab cab){
        if (cab.getCurrentTripOfCab() == null) {
            throw new TripNotFoundException();
        }
        cab.setIsAvailableOfCab(true);
        cab.getCurrentTripOfCab().endTrip();
        cab.setCurrentTripOfCab(null);
    }
}
