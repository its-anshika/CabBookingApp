package com.example.CabBooking.controller;

import com.example.CabBooking.database.CabsRepository;
import com.example.CabBooking.database.TripsRepository;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabController {
    private CabsRepository cabsRepository;
    private TripsRepository tripsRepository;

    @Autowired
    public CabController(CabsRepository cabsRepository, TripsRepository tripsRepository){
        this.cabsRepository = cabsRepository;
        this.tripsRepository = tripsRepository;
    }

    @RequestMapping(value = "/register/cab", method = RequestMethod.POST)
//    public ResponseEntity createCab(String id, String riderName){
    public ResponseEntity<String> createCab(@RequestParam String id, @RequestParam String riderName) {
        cabsRepository.createCab(new Cab(id, riderName));
        return ResponseEntity.ok("Cab registered successfully!");
    }
//query param: @RequestParam, eg: http://localhost:8080/register/cab?id=CAB123&riderName=JohnDoe

    @RequestMapping(value = "/update/cab/location", method = RequestMethod.POST)
    public ResponseEntity<String> updateCabLocation(
            @RequestParam final String cabId,@RequestParam final Double newX,@RequestParam final Double newY) {

        cabsRepository.updateCabLocation(cabId, new Location(newX, newY));
        return ResponseEntity.ok("Cab location updated");
    }

    @RequestMapping(value = "/update/cab/availability", method = RequestMethod.POST)
    public ResponseEntity<String> updateCabAvailability(
            @RequestParam String id,
            @RequestParam Boolean newAvailability) {

        System.out.println("Cab ID: " + id);
        System.out.println("New Availability: " + newAvailability);

        cabsRepository.updateCabAvailability(id, newAvailability);
        return ResponseEntity.ok("Cab availability updated");
    }
    //http://localhost:8080/update/cab/availability?id=CAB123&newAvailability=false

    @RequestMapping(value = "/cab/end/trip", method = RequestMethod.POST)
    public ResponseEntity<String> endTrip(@RequestParam final String id) {
        tripsRepository.endTrip(cabsRepository.getCab(id));
        return ResponseEntity.ok("Trip ended");
    }


}
