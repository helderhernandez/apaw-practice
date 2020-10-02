package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class FilmDirectorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(FilmDirectorResource.FILMDIRECTORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FilmDirector.class)
                .value(Assertions::assertNotNull)
                .hasSize(5);
    }
}
