package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RecipeResource.RECIPES)
public class RecipeResource {
    static final String RECIPES = "/kitchen/recipes";

    private RecipeService recipeService;

    @Autowired
    public RecipeResource(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping
    public void create(@RequestBody RecipeCreation recipeCreation) {
        return this.recipeService.create(recipeCreation);
    }

}
