package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class AnimalResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(AnimalResource.ANIMALS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Animal.class)
                .value(Assertions::assertNotNull);
    }
}
