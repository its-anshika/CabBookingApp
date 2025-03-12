package com.example.CabBooking.controller;

import com.example.CabBooking.database.RidersRepository;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RiderController {
    private RidersRepository ridersRepository;

    @Autowired
    public RiderController(RidersRepository ridersRepository){
        this.ridersRepository = ridersRepository;
    }

    @RequestMapping(value = "/register/rider", method= RequestMethod.POST)
    public ResponseEntity<String> createRider(@RequestParam String id, @RequestParam String riderName) {
        ridersRepository.createRider(new Rider(id, riderName));
        return ResponseEntity.ok("Rider registered successfully!");
    }
}
