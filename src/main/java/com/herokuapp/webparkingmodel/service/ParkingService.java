package com.herokuapp.webparkingmodel.service;

import com.herokuapp.webparkingmodel.exception.ParkingNotFoundException;
import com.herokuapp.webparkingmodel.model.Parking;
import com.herokuapp.webparkingmodel.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    private static String getUUID(){

        return UUID.randomUUID().toString().replace("-", "");
    }
    @Transactional(readOnly = true)
    public List<Parking> findAll(){

        return parkingRepository.findAll();
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Parking findById(String id) {

        return parkingRepository.findById(id).orElseThrow( () ->
                new ParkingNotFoundException(id));
    }
    @Transactional
    public Parking create(Parking parkingCreate) {
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);

        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkingCreate) {
        Parking parking = findById(id);
        parking.setModel(parkingCreate.getModel());
        parking.setColor(parkingCreate.getColor());
        parking.setState(parkingCreate.getState());
        parking.setLicense(parkingCreate.getLicense());
        parkingRepository.save(parking);
        return parking;

    }

    public Parking checkout(String id) {
        Parking parking = findById(id);
        parking.setExitDate(LocalDateTime.now());
        parking.setBill(ParkingCheckout.getBill(parking));
        parkingRepository.save(parking);
        return parking;
    }

}
