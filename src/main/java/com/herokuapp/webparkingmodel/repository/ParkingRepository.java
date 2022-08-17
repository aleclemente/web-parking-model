package com.herokuapp.webparkingmodel.repository;

import com.herokuapp.webparkingmodel.model.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {


}
