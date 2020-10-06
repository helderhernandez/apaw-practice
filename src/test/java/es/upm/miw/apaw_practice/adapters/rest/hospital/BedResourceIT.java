package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
class BedResourceIT {

    @Autowired
    WebTestClient webTestClient;

    @Test
    void testUpdateOccupied(){
        this.webTestClient
                .put()
                .uri(BedResource.BEDS + BedResource.ID_ID + BedResource.OCCUPIED,"")
                .body(BodyInserters.fromValue(Boolean.TRUE))
                .exchange()
                .expectStatus().isNotFound();
    }
}
