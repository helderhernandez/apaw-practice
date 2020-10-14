package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus.JourneyPersistence;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@RestTestConfig
class PassengerBusResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private JourneyPersistence journeyPersistence;


    void testIdJoruney(List<String> idJourneys, String idJourney) {

        boolean hasIdJourney = idJourneys.stream().anyMatch(id -> id.contains(idJourney));
        assertEquals(Boolean.TRUE, hasIdJourney);
    }

    @Test
    void testFindIdJourneysFromNamePassenger() {

        String idJourney = journeyPersistence.findIdByDepartureAndArrive("Madrid", "Barcelona");

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PassengerBusResource.PASSENGERS_BUS + PassengerBusResource.SEARCH)
                        .queryParam("q", "name:Ana")
                        .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(list -> testIdJoruney(list, idJourney));

    }

    @Test
    void testFindIdJourneysFromNamePassengerNotFound() {

        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(PassengerBusResource.PASSENGERS_BUS + PassengerBusResource.SEARCH)
                        .queryParam("q", "name:Beatriz")
                        .build()
                )
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .hasSize(1)
                .value(element -> "[]".equals(element));

    }
}
