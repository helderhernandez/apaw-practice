package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.IngredientRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import es.upm.miw.apaw_practice.domain.models.kitchen.IngredientPricePerKgUpdating;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static es.upm.miw.apaw_practice.adapters.rest.kitchen.IngredientResource.INGREDIENTS;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class IngredientResourceIT {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testReadAll() {
        this.webTestClient
                .get()
                .uri(INGREDIENTS)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Ingredient.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> ingredientNames = entityList.getResponseBody().stream()
                            .map(Ingredient::getName)
                            .collect(Collectors.toList());
                    assertTrue(ingredientNames.containsAll(List.of("Cacao en polvo", "Calabaza", "Calabacín", "Avena")));
                    assertFalse(ingredientNames.contains("chocolate"));
                });
    }

    @Test
    void testUpdatePricePerKg() {
        List<IngredientEntity> ingredients = ingredientRepository.findAll();
        List<IngredientPricePerKgUpdating> newPricesPerKg = Arrays.asList(
                new IngredientPricePerKgUpdating(ingredients.get(0).getId(), BigDecimal.TEN),
                new IngredientPricePerKgUpdating(ingredients.get(1).getId(), BigDecimal.ONE)
        );

        this.webTestClient
                .patch()
                .uri(IngredientResource.INGREDIENTS)
                .body(BodyInserters.fromValue(newPricesPerKg))
                .exchange()
                .expectStatus().isOk();

    }
}
