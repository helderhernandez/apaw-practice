package es.upm.miw.apaw_practice.adapters.rest.videoclub;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDate;

import static es.upm.miw.apaw_practice.adapters.rest.videoclub.FilmMakerResource.FILMMAKERS;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class FilmMakerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        FilmMaker filmMaker = new FilmMaker("filmMaker7", "Todd Phillips",
                LocalDate.of(1970, 2, 12), "M");
        this.webTestClient
                .post()
                .uri(FILMMAKERS)
                .body(BodyInserters.fromValue(filmMaker))
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmMaker.class)
                .value(Assertions::assertNotNull)
                .value(filmMakerData -> assertNotNull(filmMakerData.getId()));
    }
}
