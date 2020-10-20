package es.upm.miw.apaw_practice.adapters.rest.basketball;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class CourtResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateCapacity() {
        this.webTestClient
                .put()
                .uri(CourtResource.COURTS + CourtResource.ID_ID + CourtResource.CAPACITY, "")
                .body(BodyInserters.fromValue(1000))
                .exchange()
                .expectStatus().isNotFound();

    }
}
