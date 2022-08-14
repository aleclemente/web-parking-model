package com.herokuapp.webparkingmodel.service;

import com.herokuapp.webparkingmodel.controller.dto.ParkingDTO;
import com.herokuapp.webparkingmodel.model.Parking;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {
    private static Map<String, Parking> parkingMap = new HashMap<>();

    static {
        var id = getUUID();
        Parking parking = new Parking(id, "OKA-4417", "RN", "Ford Fiesta", "Preto");
        parkingMap.put(id, parking);
    }

    public List<Parking> findAll(){
        return parkingMap.values().stream().collect(Collectors.toList());
    }

    private static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
