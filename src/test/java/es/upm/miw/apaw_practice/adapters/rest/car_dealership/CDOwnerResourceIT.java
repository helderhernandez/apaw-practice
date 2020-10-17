package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import static es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDOwnerResource.*;

@RestTestConfig
public class CDOwnerResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindOwnerByBrand() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->  uriBuilder.path(OWNERS + SEARCH)
                        .queryParam("q", "brand:Ford")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBody();
    }

}
