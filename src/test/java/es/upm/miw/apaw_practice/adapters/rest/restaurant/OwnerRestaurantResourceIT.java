package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class OwnerRestaurantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadName() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(OwnerRestaurantResource.OWNERS + OwnerRestaurantResource.OWNERNAME)
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NameDto.class)
                .value(Assertions::assertNotNull)
                .value(owner -> assertEquals("name1", owner.get(0).getName()));
    }
}
