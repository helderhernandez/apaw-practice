package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import es.upm.miw.apaw_practice.domain.models.movie.CinemaMovieTicketPriceUpdating;
import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import es.upm.miw.apaw_practice.domain.models.movie.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
public class CinemaResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateMovieTicketPricesNotFound() {
        List<CinemaMovieTicketPriceUpdating> cinemaMovieTicketPriceUpdatingeList = Arrays.asList(
                new CinemaMovieTicketPriceUpdating("YelmoCi", new BigDecimal("11.40")));
        this.webTestClient
                .patch()
                .uri(CinemaResource.CINEMAS)
                .body(BodyInserters.fromValue(cinemaMovieTicketPriceUpdatingeList))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testUpdateMovieTicketPricesOk() {
        List<CinemaMovieTicketPriceUpdating> cinemaMovieTicketPriceUpdatingeList = Arrays.asList(
                new CinemaMovieTicketPriceUpdating("YelmoCine", new BigDecimal("11.40")),
                new CinemaMovieTicketPriceUpdating("OdeonCine", new BigDecimal("5.35")));
        this.webTestClient
                .patch()
                .uri(CinemaResource.CINEMAS)
                .body(BodyInserters.fromValue(cinemaMovieTicketPriceUpdatingeList))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindByNameAndFulNameDirector(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(CinemaResource.CINEMAS + CinemaResource.SEARCH)
                                .queryParam("q", "name:Pedro;fulName:Munoz Roda")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Cinema.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> cinemaList = entityList.getResponseBody().stream()
                            .map(Cinema::getCinemaName)
                            .collect(Collectors.toList());
                    assertEquals(1, cinemaList.size());
                    assertTrue(cinemaList.contains("Cinepolis"));
                });
    }
}
