package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;
import java.util.stream.Collectors;

import static es.upm.miw.apaw_practice.adapters.rest.kitchen.IngredientResource.INGREDIENTS;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class IngredientResourceIT {

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
}
