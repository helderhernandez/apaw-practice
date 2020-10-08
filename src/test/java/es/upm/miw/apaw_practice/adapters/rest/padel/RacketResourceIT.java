package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.models.shop.ArticlePriceUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static es.upm.miw.apaw_practice.adapters.rest.padel.RacketResource.*;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class RacketResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePrices(){
        RacketPriceUpdating racketPriceUpdating = new RacketPriceUpdating("BRAND-A", BigDecimal.ONE);

        this.webTestClient
                .patch()
                .uri(RACKETS)
                .body(BodyInserters.fromValue(racketPriceUpdating))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePricesNotFound(){
        RacketPriceUpdating racketPriceUpdating = new RacketPriceUpdating("BRAND-XXX", BigDecimal.ONE);

        this.webTestClient
                .patch()
                .uri(RACKETS)
                .body(BodyInserters.fromValue(racketPriceUpdating))
                .exchange()
                .expectStatus().isNotFound();
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(RACKETS + ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testfindBrandRacketPlayersToPlayInLevelTournamentGreaterThanZero(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(RACKETS + SEARCH)
                                .queryParam("q", "level:0")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BrandRacketDto.class)
                .value(racketDtos -> assertFalse(racketDtos.isEmpty()))
                .value(racketDtos -> assertEquals("BRAND-A",racketDtos.get(0).getBrand()))
                .value(racketDtos -> assertEquals("BRAND-B",racketDtos.get(1).getBrand()))
                .value(racketDtos -> assertEquals("BRAND-D",racketDtos.get(2).getBrand()));
    }

    @Test
    void testfindBrandRacketPlayersToPlayInLevelTournamentGreaterThanThree(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(RACKETS + SEARCH)
                                .queryParam("q", "level:3")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BrandRacketDto.class)
                .value(racketDtos -> assertFalse(racketDtos.isEmpty()))
                .value(racketDtos -> assertEquals("BRAND-E",racketDtos.get(0).getBrand()));
    }
}
