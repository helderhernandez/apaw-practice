package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RestTestConfig
class TournamentResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateStartDay() {
        this.webTestClient
                .put()
                .uri(TournamentResource.TOURNAMENT + TournamentResource.ID_ID + TournamentResource.START_DAY, "")
                .body(BodyInserters.fromValue(LocalDateTime.now()))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testfindByTournamentsAndNameDistintOfPlayer() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(TournamentResource.TOURNAMENT + TournamentResource.SEARCH)
                                .queryParam("q", "name:Andrea")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NameTournamentDto.class)
                .value(tournamentsName -> assertFalse(tournamentsName.isEmpty()))
                .value(tournamentsName -> assertEquals("TORNEO-C", tournamentsName.get(0).getName()))
                .value(tournamentsName -> assertEquals("TORNEO-D", tournamentsName.get(1).getName()));
    }
}
