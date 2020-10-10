package es.upm.miw.apaw_practice.adapters.rest.FurnitureFactory;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.FurnitureFactory.Furniture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class FurnitureResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(FurnitureResource.FURNITURE)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Furniture.class)
                .value(Assertions::assertNotNull)
                .hasSize(4);
    }

}
