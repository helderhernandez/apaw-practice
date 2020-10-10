package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.kitchen.Recipe;
import es.upm.miw.apaw_practice.domain.models.kitchen.RecipeCreation;
import es.upm.miw.apaw_practice.domain.services.kitchen.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(RecipeResource.RECIPES)
public class RecipeResource {
    static final String RECIPES = "/kitchen/recipes";
    static final String SEARCH = "/search";

    private RecipeService recipeService;

    @Autowired
    public RecipeResource(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public Recipe create(@RequestBody RecipeCreation recipeCreation) {
        return this.recipeService.create(recipeCreation);
    }

    @GetMapping(SEARCH)
    public Stream<String> search1(@RequestParam String q) {
        String dni = new LexicalAnalyzer().extractWithAssure(q, "dni");
        return this.recipeService.search1(dni);
    }
}
