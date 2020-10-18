package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CategoryCreationSporty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.CategorySportyResource.CATEGORIES_SPORTY;
import static es.upm.miw.apaw_practice.adapters.rest.sportyrental.CategorySportyResource.ID_CATEGORY;

@RestTestConfig
class CategorySportyResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateNotFound() {
        CategoryCreationSporty categoryCreationSporty = new CategoryCreationSporty("Fronton", 4);

        this.webTestClient
                .put()
                .uri(CATEGORIES_SPORTY + ID_CATEGORY, "50")
                .body(BodyInserters.fromValue(categoryCreationSporty))
                .exchange()
                .expectStatus().isNotFound();

    }
}
