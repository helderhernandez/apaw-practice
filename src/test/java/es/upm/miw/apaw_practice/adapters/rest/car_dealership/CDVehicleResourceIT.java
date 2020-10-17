package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDVehicleResource.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class CDVehicleResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void createTest() {
        CDVehicleCreation vehicleCreation = new CDVehicleCreation("PEPR43A", "Volkswagen", "Golf", true, 2018);
        this.webTestClient
                .post()
                .uri(VEHICLES)
                .body(BodyInserters.fromValue(vehicleCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CDVehicle.class);
    }

    @Test
    void testUpdateBrand() {
        CDBrandDto brand = new CDBrandDto("Seat");

        this.webTestClient
                .put()
                .uri(VEHICLES + FRAME_FRAME + BRAND, "DDS223A")
                .body(BodyInserters.fromValue(brand))
                .exchange()
                .expectStatus().isOk()
                .expectBody(CDVehicle.class)
                .value(vehicle -> assertEquals(vehicle.getBrand(), brand.getBrand()));
    }

    @Test
    void testUpdateBrandNotFound() {
        CDBrandDto brand = new CDBrandDto("Seat");

        this.webTestClient
                .put()
                .uri(VEHICLES + FRAME_FRAME + BRAND, "Not a frame")
                .body(BodyInserters.fromValue(brand))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testFindBrandByEmployeeName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder.path(VEHICLES + SEARCH)
                        .queryParam("q", "name:Pablo Coronado")
                        .build())
                .exchange()
                .expectStatus().isOk();
    }
}
