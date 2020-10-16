package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.race.Race;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class RaceResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateLocation() {
        LocationDto locationDto = new LocationDto("Bilbao");

        webTestClient
                .put()
                .uri(RaceResource.RACES + RaceResource.ID_ID, "2")
                .body(BodyInserters.fromValue(locationDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Race.class)
                .value(Assertions::assertNotNull)
                .value(race -> assertEquals("2", race.getId()))
                .value(race -> assertEquals("Bilbao", race.getLocation()));
    }

    @Test
    void testDeleteSection() {
        webTestClient
                .delete()
                .uri(RaceResource.RACES + RaceResource.ID_ID + RaceResource.SECTIONS + RaceResource.ORDER, "2", "3")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testDeleteSectionNotFound() {
        webTestClient
                .delete()
                .uri(RaceResource.RACES + RaceResource.ID_ID + RaceResource.SECTIONS + RaceResource.ORDER, "-1", "3")
                .exchange()
                .expectStatus().isNotFound();
    }

}
