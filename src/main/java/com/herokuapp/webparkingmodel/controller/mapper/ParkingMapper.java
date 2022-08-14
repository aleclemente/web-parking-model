package com.herokuapp.webparkingmodel.controller.mapper;

import com.herokuapp.webparkingmodel.controller.dto.ParkingCreateDTO;
import com.herokuapp.webparkingmodel.controller.dto.ParkingDTO;
import com.herokuapp.webparkingmodel.model.Parking;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParkingMapper {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    public ParkingDTO toParkingDTO(Parking parking){
        return MODEL_MAPPER.map(parking, ParkingDTO.class);
    }

    public List<ParkingDTO> toParkingDTOList(List<Parking> parkingList) {
        return parkingList.stream().map(this::toParkingDTO).collect(Collectors.toList());
    }

    public Parking toParking(ParkingDTO parkingDTO) {
        return MODEL_MAPPER.map(parkingDTO, Parking.class);
    }

    public Parking toParkingCreate(ParkingCreateDTO parkingCreateDTO) {
        return MODEL_MAPPER.map(parkingCreateDTO, Parking.class);
    }

}
