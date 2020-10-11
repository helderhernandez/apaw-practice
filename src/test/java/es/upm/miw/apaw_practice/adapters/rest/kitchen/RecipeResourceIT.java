package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence.IngredientPersistenceMongodb;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
class RecipeResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Autowired
    private IngredientPersistenceMongodb ingredientPersistence;

    @Test
    void testCreate() {
        List<String> ingredientIds = this.ingredientPersistence.readAll()
                .filter(ingredient -> ingredient.getName().equals("Calabaza") || ingredient.getName().equals("Cacao en polvo"))
                .map(ingredient -> ingredient.getId())
                .collect(Collectors.toList());

        RecipeCreation recipeCreation = new RecipeCreation("Donuts", ingredientIds);

        this.webTestClient
                .post()
                .uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromValue(recipeCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Recipe.class)
                .value(Assertions::assertNotNull)
                .value(recipe -> assertNotNull(recipe.getId()));
    }

    @Test
    void testCreateConflict() {
        List<String> ingredientIds = this.ingredientPersistence.readAll()
                .filter(ingredient -> ingredient.getName().equals("Calabaza") || ingredient.getName().equals("Cacao en polvo"))
                .map(ingredient -> ingredient.getId())
                .collect(Collectors.toList());

        RecipeCreation recipeCreation = new RecipeCreation("Cupcakes", ingredientIds);

        this.webTestClient
                .post()
                .uri(RecipeResource.RECIPES)
                .body(BodyInserters.fromValue(recipeCreation))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.CONFLICT);
    }

    @Test
    void testSearch1() {
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(RecipeResource.RECIPES + RecipeResource.SEARCH)
                        .queryParam("q", "dni:12345678A")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .value(recipes -> assertTrue(recipes.size() > 0))
                .value(recipes -> System.out.println(recipes.get(0)));
        //TODO Devuelve una lista de un solo elemento que contiene todos los nombres de las recetas, arreglar
    }
}
