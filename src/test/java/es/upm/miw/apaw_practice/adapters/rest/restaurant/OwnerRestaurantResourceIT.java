package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos.OwnerRestaurantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.OwnerRestaurantEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurantUpdate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RestTestConfig
public class OwnerRestaurantResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private OwnerRestaurantRepository ownerRestaurantRepository;

    @Test
    void testReadName() {
        this.webTestClient
                .get()
                .uri(OwnerRestaurantResource.OWNERS + OwnerRestaurantResource.OWNERNAME)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(NameDto.class)
                .value(Assertions::assertNotNull)
                .value(owner -> assertEquals("name1", owner.get(0).getName()))
                .value(owner -> assertEquals("name2", owner.get(1).getName()));
    }

    @Test
    void testUpdateOwner() {
        List<OwnerRestaurantEntity> ownerRestaurantEntity = ownerRestaurantRepository.findAll();
        OwnerRestaurantUpdate ownerRestaurantUpdate = new OwnerRestaurantUpdate("Laura", "Garcia");
        this.webTestClient
                .put()
                .uri(OwnerRestaurantResource.OWNERS + OwnerRestaurantResource.ID_ID, ownerRestaurantEntity.get(2).getId())
                .body(BodyInserters.fromValue(ownerRestaurantUpdate))
                .exchange()
                .expectStatus().isOk()
                .expectBody(OwnerRestaurant.class)
                .value(owner -> assertEquals("Laura", owner.getName()))
                .value(owner -> assertEquals("Garcia", owner.getFamilyName()));
    }

    @Test
    void testUpdateOwnerNotFound() {
        OwnerRestaurantUpdate ownerRestaurantUpdate = new OwnerRestaurantUpdate("Laura", "Garcia");
        this.webTestClient
                .put()
                .uri(OwnerRestaurantResource.OWNERS + OwnerRestaurantResource.ID_ID, "tag5")
                .body(BodyInserters.fromValue(ownerRestaurantUpdate))
                .exchange()
                .expectStatus().isNotFound();
    }
}
