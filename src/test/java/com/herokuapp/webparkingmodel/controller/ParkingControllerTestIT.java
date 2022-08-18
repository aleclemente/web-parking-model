package com.herokuapp.webparkingmodel.controller;

import com.herokuapp.webparkingmodel.controller.dto.ParkingCreateDTO;
import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
//Random port para o teste não atrapalhar as portas da aplicação
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerTestIT  extends AbstractContainerBase {
    //TODO: Encriptografar as senha antes do teste
    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        RestAssured.port = randomPort;
    }

    @Test
    @DisplayName("Processo de recuperação de Parkings")
    void whenFindAllThenResult() {
        RestAssured.given()
                .auth()
                .basic("user", "password")
                .when()
                .get("/parkings")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("license[0]", Matchers.equalTo("OKA-4417"));
    }

    @Test
    @DisplayName("Processo de criação de parking")
    void create() {

        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("Azul");
        createDTO.setLicense("DMZ-1234");
        createDTO.setModel("Honda Fit");
        createDTO.setState("RN");

        RestAssured.given()
                .auth()
                .basic("user", "test")
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parkings")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body("license", Matchers.equalTo("DMZ-1234"));
    }

}