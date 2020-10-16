package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

@RestTestConfig
public class RestaurantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testFindFoodTypesAssociateToOwner() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(RestaurantResource.FOODTYPES + RestaurantResource.SEARCH)
                        .queryParam("q", "name:Lara")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class);
    }
}
