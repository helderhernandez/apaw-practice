package es.upm.miw.apaw_practice.adapters.rest.filmforum;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.filmforum.FilmForum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class FilmForumResourceIT {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testGetFilmByName() {
        webClient.get()
                .uri(uriBuilder -> uriBuilder.path(FilmForumResource.FILMFORUM_FILMS)
                        .queryParam("q", "name:film1")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(FilmForum.class)
                .value(film -> assertEquals("film1", film.getName()));
    }
}