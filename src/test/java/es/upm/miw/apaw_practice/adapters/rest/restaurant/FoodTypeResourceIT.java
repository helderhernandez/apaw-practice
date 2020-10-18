package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.RestaurantRepository;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class FoodTypeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Test
    void testUpdateSpicy() {
        FoodTypeSpicyUpdating foodTypeSpicyUpdating = new FoodTypeSpicyUpdating("foodType3", false);
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

    @Test
    void testFindFoodTypesAssociateToOwner() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(FoodTypeResource.FOODTYPES + FoodTypeResource.SEARCH)
                        .queryParam("q", "name:Lara")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(FoodTypeDto.class)
                .value(typeList -> assertEquals("foodType1", typeList.get(0).getId()))
                .value(typeList -> assertEquals("foodType5", typeList.get(2).getId()));
    }
}
