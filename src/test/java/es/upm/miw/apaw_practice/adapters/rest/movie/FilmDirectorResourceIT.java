package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testUpdateAge() {
        String id = this.webTestClient
                .get()
                .uri(FilmDirectorResource.FILMDIRECTORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FilmDirector.class)
                .returnResult()
                .getResponseBody()
                .get(0)
                .getId();
        AgeDto ageDto = new AgeDto(30);
        this.webTestClient
                .put()
                .uri(FilmDirectorResource.FILMDIRECTORS + FilmDirectorResource.ID_ID + FilmDirectorResource.AGE, id)
                .body(BodyInserters.fromValue(ageDto.getAge()))
                .exchange()
                .expectStatus().isOk();
        assertEquals(30, this.webTestClient
                                        .get()
                                        .uri(FilmDirectorResource.FILMDIRECTORS)
                                        .exchange()
                                        .expectStatus().isOk()
                                        .expectBodyList(FilmDirector.class)
                                        .returnResult()
                                        .getResponseBody()
                                        .get(0)
                                        .getAge());
    }
}
