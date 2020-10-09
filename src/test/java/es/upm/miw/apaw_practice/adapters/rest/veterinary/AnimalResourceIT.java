package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalAgeUpdating;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;


import java.util.Arrays;
import java.util.List;

import static es.upm.miw.apaw_practice.adapters.rest.veterinary.AnimalResource.ANIMALS;
import static es.upm.miw.apaw_practice.adapters.rest.veterinary.AnimalResource.ID;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class AnimalResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(ANIMALS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Animal.class)
                .value(Assertions::assertNotNull);
    }

    @Test
    void testCreate() {
        AnimalCreation animalCreation =
                new AnimalCreation("animal-key-sdfsdf", "Rayo", 2);
        this.webTestClient
                .post()
                .uri(ANIMALS)
                .body(BodyInserters.fromValue(animalCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Animal.class)
                .value(Assertions::assertNotNull)
                .value(animalData -> assertNotNull(animalData.getId()));
    }

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(ANIMALS + ID, "isAnId")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testUpdateAge() {
        AnimalCreation animalCreation = new AnimalCreation("animal-key-1111", "Aaron", 4);
        this.webTestClient
                .put()
                .uri(ANIMALS + AnimalResource.ID + AnimalResource.AGE, "notAnId")
                .body(BodyInserters.fromValue(animalCreation))
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void testUpdateAgesNotFound() {
        List<AnimalAgeUpdating> animalAgeUpdatingList = Arrays.asList(
                new AnimalAgeUpdating("", 20),
                new AnimalAgeUpdating("keyNotExists", 50)
        );
        this.webTestClient
                .patch()
                .uri(ANIMALS)
                .body(BodyInserters.fromValue(animalAgeUpdatingList))
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void testUpdateAgesFound() {
        List<AnimalAgeUpdating> animalAgeUpdatingList = Arrays.asList(
                new AnimalAgeUpdating("key-1-a", 20),
                new AnimalAgeUpdating("key-10-bd", 50)
        );
        this.webTestClient
                .patch()
                .uri(ANIMALS)
                .body(BodyInserters.fromValue(animalAgeUpdatingList))
                .exchange()
                .expectStatus()
                .isOk();
    }


}
