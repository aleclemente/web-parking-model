package com.herokuapp.webparkingmodel.service;

import com.herokuapp.webparkingmodel.exception.ParkingNotFoundException;
import com.herokuapp.webparkingmodel.model.Parking;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private static final Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "OKA-4417", "RN", "Ford Fiesta", "Preto");
        parkingMap.put(id, parking);

        var id2 = getUUID();
        Parking parking2 = new Parking(id2, "DAC-2335", "SP", "VW Gol", "Vermelho");
        parkingMap.put(id2, parking2);
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    public Parking findById(String id) {

        Parking parking = parkingMap.get(id);

        if(parking == null) {
            throw new ParkingNotFoundException(id);
        }

        return parking;
    }

    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingMap.put(uuid, parkingCreate);

        return parkingCreate;
    }

    public void delete(String id) {
        findById(id);
        parkingMap.remove(id);
    }

}
