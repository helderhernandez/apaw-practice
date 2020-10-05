package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Ingredient;
import es.upm.miw.apaw_practice.domain.services.kitchen.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(IngredientResource.INGREDIENTS)
public class IngredientResource {
    static final String INGREDIENTS = "/kitchen/ingredients";

    private IngredientService ingredientService;

    @Autowired
    public IngredientResource(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping
    public Stream<Ingredient> readAll() {
        return this.ingredientService.readAll();
    }
}
