package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Plane;
import es.upm.miw.apaw_practice.domain.models.airport.PlaneCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class PlaneResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        PlaneCreation planeCreation =
                new PlaneCreation("model", 100, false, "1001");
        this.webTestClient
                .post()
                .uri(PlaneResource.PLANES)
                .body(BodyInserters.fromValue(planeCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Plane.class)
                .value(Assertions::assertNotNull)
                .value(plane -> assertNotNull(plane.getId()))
                .value(plane -> assertEquals("1001", plane.getLicensePlate()));
    }

    @Test
    void testCreateConflict() {
        PlaneCreation planeCreation =
                new PlaneCreation("model", 100, false, "11111");
        this.webTestClient
                .post()
                .uri(PlaneResource.PLANES)
                .body(BodyInserters.fromValue(planeCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
