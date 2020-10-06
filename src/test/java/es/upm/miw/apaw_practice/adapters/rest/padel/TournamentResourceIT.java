package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;

@RestTestConfig
public class TournamentResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateStartDay(){
        this.webTestClient
                .put()
                .uri(TournamentResource.TOURNAMENT + TournamentResource.ID_ID + TournamentResource.START_DAY,"")
                .body(BodyInserters.fromValue(LocalDateTime.now()))
                .exchange()
                .expectStatus().isNotFound();
    }
}
