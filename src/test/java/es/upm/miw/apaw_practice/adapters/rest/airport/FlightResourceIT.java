package es.upm.miw.apaw_practice.adapters.rest.airport;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.airport.Flight;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
class FlightResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(FlightResource.FLIGHTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Flight.class)
                .value(Assertions::assertNotNull)
                .value(flights -> assertEquals(3, flights.size()))
                .value(flights -> assertEquals("madrid", flights.get(0).getDestinationCity()))
                .value(flights -> assertEquals("11112", flights.get(1).getPlane().getLicensePlate()));
    }
}
