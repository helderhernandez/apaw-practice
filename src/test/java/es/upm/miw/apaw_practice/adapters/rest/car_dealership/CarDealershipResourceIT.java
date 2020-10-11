package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CarDealershipResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class CarDealershipResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testRead() {
        this.webTestClient
                .get()
                .uri(CAR_DEALERSHIPS + NAME, "Concesionario Castro")
                .exchange()
                .expectStatus().isOk()
                .expectBody(CarDealership.class)
                .value(Assertions::assertNotNull)
                .value(data -> {
                    assertEquals("Concesionario Castro", data.getName());
                    assertEquals("Calle Homero, 3", data.getAddress());
                    assertEquals(666333111L, data.getTelephone());
                });
    }

    @Test
    void testReadNotFound() {
        this.webTestClient
                .get()
                .uri(CAR_DEALERSHIPS + NAME, "Concesionario López")
                .exchange()
                .expectStatus().isNotFound();
    }
}