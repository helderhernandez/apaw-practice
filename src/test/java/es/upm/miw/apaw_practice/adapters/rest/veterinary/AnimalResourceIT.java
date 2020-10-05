package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;

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

    @Test
    void testCreate() {
        AnimalCreation animalCreation =
                new AnimalCreation("", "", 10);
        this.webTestClient
                .post()
                .uri(AnimalResource.ANIMALS)
                .body(BodyInserters.fromValue(animalCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Article.class)
                .value(Assertions::assertNotNull)
                .value(articleData -> assertNotNull(articleData.getId()));
    }
}
