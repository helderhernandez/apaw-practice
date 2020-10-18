package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RestTestConfig
public class FoodTypeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testUpdateSpicy() {
        FoodTypeSpicyUpdating foodTypeSpicyUpdating = new FoodTypeSpicyUpdating("tag3", false);
        this.webTestClient
                .patch()
                .uri(FoodTypeResource.FOODTYPES)
                .body(BodyInserters.fromValue(foodTypeSpicyUpdating))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateSpicyNotFound() {
        FoodTypeSpicyUpdating foodTypeSpicyUpdating = new FoodTypeSpicyUpdating("tag4", false);
        this.webTestClient
                .patch()
                .uri(FoodTypeResource.FOODTYPES)
                .body(BodyInserters.fromValue(foodTypeSpicyUpdating))
                .exchange()
                .expectStatus().isNotFound();
    }
}
