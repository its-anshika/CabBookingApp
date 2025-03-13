package com.example.CabBooking.database;

import com.example.CabBooking.exceptions.RiderAlreadyExistsException;
import com.example.CabBooking.exceptions.RiderNotFoundException;
import com.example.CabBooking.model.Rider;
import lombok.NonNull;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class RidersRepository {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull Rider newRider){
        if(riders.containsKey(newRider.getRiderId()))
            throw new RiderAlreadyExistsException();
        riders.put(newRider.getRiderId(), newRider);
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}
