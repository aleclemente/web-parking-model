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

    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setModel(parkingCreate.getModel());
        parking.setState(parkingCreate.getState());
        parking.setColor(parkingCreate.getColor());
        parking.setLicense(parkingCreate.getLicense());
        parkingMap.replace(id, parking);
        return parking;

    }

/*    public Parking exit(String id) {
        //TODO: recuperar o estacionado
        //TODO: atualizar data de saida
        //TODO: Calcular valor
        retun "";
    }*/

}
