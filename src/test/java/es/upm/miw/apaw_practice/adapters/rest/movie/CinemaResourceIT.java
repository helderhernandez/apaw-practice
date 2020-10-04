package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.movie.CinemaMovieTicketPriceUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
}
