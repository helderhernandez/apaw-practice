package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        FilmDirectorEntity filmDirectorEntity = FilmDirectorEntity.builder().name("Jose").fulName("Luis Rodriguez").age(38).build();
        filmDirectorEntity.setId(filmDirectorEntityId);
        Movie movie =
                new Movie("La ola", filmDirectorEntity, LocalDateTime.parse("1996-03-08 10:30", formatter), "mmmmmm", 9);
        this.webTestClient
                .post()
                .uri(MovieResource.MOVIES)
                .body(BodyInserters.fromValue(movie))
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
        FilmDirectorEntity filmDirectorEntity = FilmDirectorEntity.builder().name("Jose").fulName("Luis Rodriguez").age(38).build();
        filmDirectorEntity.setId(filmDirectorEntityId);
        Movie movie =
                new Movie("Frozen", filmDirectorEntity, LocalDateTime.parse("1986-04-08 10:30", formatter), "ppppppp", 10);
        this.webTestClient
                .post()
                .uri(MovieResource.MOVIES)
                .body(BodyInserters.fromValue(movie))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(MovieResource.MOVIES + MovieResource.ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindByCinemaFilmRoomsWithMoreThanNumberOfSeats(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(MovieResource.MOVIES + MovieResource.SEARCH)
                                .queryParam("q", "numberOfSeats:160")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Movie.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> movieList = entityList.getResponseBody().stream()
                            .map(Movie::getFilmTitle)
                            .collect(Collectors.toList());
                    assertEquals(3, movieList.size());
                    assertTrue(movieList.containsAll(Arrays.asList("Let's Be Cops", "The dark Knight", "The Simpsons")));
                    assertTrue(movieList.contains("Let's Be Cops"));
                });
    }
}
