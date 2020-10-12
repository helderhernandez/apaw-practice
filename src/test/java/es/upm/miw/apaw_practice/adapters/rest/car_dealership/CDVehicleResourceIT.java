package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class CDVehicleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createTest() {
        CDVehicleCreation vehicleCreation = new CDVehicleCreation("Volkswagen", "Golf", true, 2018);
        this.webTestClient
                .post()
                .uri(CDVehicleResource.VEHICLES)
                .body(BodyInserters.fromValue(vehicleCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CDVehicle.class);
    }
}
