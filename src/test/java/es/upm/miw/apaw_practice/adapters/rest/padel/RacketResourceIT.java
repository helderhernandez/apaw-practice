package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.models.shop.ArticlePriceUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

@RestTestConfig
public class RacketResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdatePrices(){
        RacketPriceUpdating racketPriceUpdating = new RacketPriceUpdating("BRAND-A", BigDecimal.ONE);

        this.webTestClient
                .patch()
                .uri(RacketResource.RACKETS)
                .body(BodyInserters.fromValue(racketPriceUpdating))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdatePricesNotFound(){
        RacketPriceUpdating racketPriceUpdating = new RacketPriceUpdating("BRAND-XXX", BigDecimal.ONE);

        this.webTestClient
                .patch()
                .uri(RacketResource.RACKETS)
                .body(BodyInserters.fromValue(racketPriceUpdating))
                .exchange()
                .expectStatus().isNotFound();
    }
}