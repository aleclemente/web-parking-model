package com.herokuapp.webparkingmodel.controller.dto;

import lombok.Data;
@Data
public class ParkingCreateDTO {
    private String model;
    private String color;
    private String state;
    private String license;
}
