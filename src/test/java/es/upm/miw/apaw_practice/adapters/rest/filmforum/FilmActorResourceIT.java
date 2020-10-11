package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActorCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class FilmActorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        FilmActorCreation creation = new FilmActorCreation("Ben", "Affleck", 40);
        webTestClient.post()
                .uri(FilmActorResource.FILMACTOR)
                .body(BodyInserters.fromValue(creation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmActor.class)
                .value(Assertions::assertNotNull);
    }
}
