package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import es.upm.miw.apaw_practice.domain.models.movie.MovieCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class MovieResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String filmDirectorEntityId = this.webTestClient
                .get()
                .uri(FilmDirectorResource.FILMDIRECTORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FilmDirector.class)
                .returnResult()
                .getResponseBody()
                .get(0)
                .getId();
        FilmDirectorEntity filmDirectorEntity = new FilmDirectorEntity("Jose", "Luis Rodriguez", 38);
        filmDirectorEntity.setId(filmDirectorEntityId);
        MovieCreation movieCreation =
                new MovieCreation("La ola", filmDirectorEntity, LocalDateTime.parse("1996-03-08 10:30", formatter), "mmmmmm", 9);
        this.webTestClient
                .post()
                .uri(MovieResource.MOVIES)
                .body(BodyInserters.fromValue(movieCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Movie.class)
                .value(Assertions::assertNotNull)
                .value(movieData -> assertNotNull(movieData.getId()));
    }

    @Test
    void testCreateConflict() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String filmDirectorEntityId = this.webTestClient
                .get()
                .uri(FilmDirectorResource.FILMDIRECTORS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FilmDirector.class)
                .returnResult()
                .getResponseBody()
                .get(0)
                .getId();
        FilmDirectorEntity filmDirectorEntity = new FilmDirectorEntity("Jose", "Luis Rodriguez", 38);
        filmDirectorEntity.setId(filmDirectorEntityId);
        MovieCreation movieCreation =
                new MovieCreation("Frozen", filmDirectorEntity, LocalDateTime.parse("1986-04-08 10:30", formatter), "ppppppp", 10);
        this.webTestClient
                .post()
                .uri(MovieResource.MOVIES)
                .body(BodyInserters.fromValue(movieCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }
}
