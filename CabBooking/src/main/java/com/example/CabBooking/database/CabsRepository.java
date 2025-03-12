package com.example.CabBooking.database;

import com.example.CabBooking.exceptions.CabNotFoundException;
import com.example.CabBooking.model.Cab;
import com.example.CabBooking.model.Location;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CabsRepository {
    Map<String, Cab> cabs = new HashMap<>();// Cab id, cab

    public void createCab(final Cab newCab){
        if (cabs.containsKey(newCab.getCabId()))
            System.out.println("Cab already exists!");
        else
            cabs.put(newCab.getCabId(), newCab);
    }
    public Cab getCab(@NonNull final String cabId) {
        if (!cabs.containsKey(cabId)) {
//            System.out.println("Cab not found!");
            throw new CabNotFoundException();
        }
        return cabs.get(cabId);
    }

    public void updateCabLocation(@NonNull final String id, @NonNull final Location newLocation) {
        if (!cabs.containsKey(id)) {
            throw new CabNotFoundException();
        }
        cabs.get(id).setCurrentLocationOfCab(newLocation);
    }

    public void updateCabAvailability(String id, Boolean newAv){
        if (!cabs.containsKey(id)) {
            throw new CabNotFoundException();
        }
        cabs.get(id).setIsAvailableOfCab(newAv);

    }
}

