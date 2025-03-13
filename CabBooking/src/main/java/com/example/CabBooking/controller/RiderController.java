package com.example.CabBooking.controller;

import com.example.CabBooking.database.RidersRepository;
import com.example.CabBooking.database.TripsRepository;
import com.example.CabBooking.exceptions.RiderNotFoundException;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Location;
import com.example.CabBooking.model.Rider;
import com.example.CabBooking.model.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiderController {
    private final RidersRepository ridersRepository;
    private final TripsRepository tripsRepository;

    @Autowired
    public RiderController(RidersRepository ridersRepository, TripsRepository tripsRepository){
        this.tripsRepository = tripsRepository;
        this.ridersRepository = ridersRepository;
    }

    @RequestMapping(value = "/register/rider", method= RequestMethod.POST)
    public ResponseEntity<String> createRider(@RequestParam String id, @RequestParam String riderName) {
        ridersRepository.createRider(new Rider(id, riderName));
        return ResponseEntity.ok("Rider registered successfully!");
    }
//http://localhost:8080/register/rider?id=ajayID&riderName=Ajay

    @RequestMapping(value = "/book", method= RequestMethod.POST)
    public ResponseEntity<String> bookCab(@RequestParam String riderId,
                                          @RequestParam Double fromX,
                                          @RequestParam Double fromY,
                                          @RequestParam Double toX,
                                          @RequestParam Double toY) {
        Rider rider = ridersRepository.getRider(riderId);
        if(rider == null)
            throw new RiderNotFoundException();
        tripsRepository.createTrip(rider, new Location(fromX,fromY), new Location(toX, toY) );
        return ResponseEntity.ok("Cab booked successfully!");
    }
//http://localhost:8080/book?riderId=ajayID&fromX=10.0&fromY=20.0&toX=15.0&toY=25.0

    @RequestMapping(value = "/get/history", method= RequestMethod.GET)
    public ResponseEntity<String> getHistory(@RequestParam String riderId){
//        Rider rider = ridersRepository.getRider(riderId);
        List<Trip> historyOfRider = tripsRepository.getHistory(riderId);
        return ResponseEntity.ok("History of cabs booked shown for rider successfully!");

    }
}
