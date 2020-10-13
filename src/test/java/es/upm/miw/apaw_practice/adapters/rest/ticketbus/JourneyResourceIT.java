package es.upm.miw.apaw_practice.adapters.rest.ticketbus;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
class JourneyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    void testJourney(Journey journey){
        assertNotNull(journey);
        assertNotNull(journey.getReference());
        assertEquals("Madrid", journey.getDeparture());
        assertEquals("Barcelona", journey.getArrive());
        assertEquals(5, journey.getNumStops());
    }

    @Test
    void testFindAll(){

        this.webTestClient
                .get()
                .uri(JourneyResource.JOURNEYS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Journey.class)
                .value(Assertions::assertNotNull)
                .value(journeys -> assertEquals(2, journeys.size()))
                .value(journeys -> testJourney(journeys.get(0)));
    }
}
