package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.DiscountSportyResource.DISCOUNTS_SPORTY;
import static es.upm.miw.apaw_practice.adapters.rest.sportyRental.DiscountSportyResource.ID_DISCOUNT;

@RestTestConfig
class DiscountSportyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound() {

        this.webTestClient
                .patch()
                .uri(DISCOUNTS_SPORTY + ID_DISCOUNT, 50)
                .body(BodyInserters.fromValue(40.0))
                .exchange()
                .expectStatus().isNotFound();

    }
}
