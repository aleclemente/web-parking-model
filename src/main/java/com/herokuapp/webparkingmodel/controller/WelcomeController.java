package com.herokuapp.webparkingmodel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
@ApiIgnore
public class WelcomeController {
    @GetMapping
    public String welcomeMessage(){
        return "Welcome to Web Parking Model Application!";
    }

}