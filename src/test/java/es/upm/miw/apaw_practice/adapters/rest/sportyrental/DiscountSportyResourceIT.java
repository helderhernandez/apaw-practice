package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.DiscountSportyResource.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testDescriptionsDiscountByNumMaxPersonGreaterThan() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(DISCOUNTS_SPORTY + SEARCH_DISCOUNT_DESCRIPTIONS)
                                .queryParam("q", "numMaxPerson:9")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(Assertions::assertNotNull)
                .value(String -> assertEquals("[[\"Impairment\",\"Large Family\"]]", String.toString()));
    }
}
