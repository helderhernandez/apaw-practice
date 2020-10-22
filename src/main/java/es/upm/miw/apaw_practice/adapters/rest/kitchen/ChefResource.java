package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import es.upm.miw.apaw_practice.domain.services.kitchen.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ChefResource.CHEF)
public class ChefResource {
    static final String CHEF = "/kitchen/chef";
    static final String DNI = "/{dni}";
    static final String RECIPES_FINISHED = "/recipesFinished";
    static final String SEARCH = "/search";

    private ChefService chefService;

    @Autowired
    public ChefResource(ChefService chefService) {
        this.chefService = chefService;
    }

    @PutMapping(DNI + RECIPES_FINISHED)
    public Chef updateRecipesFinished(@PathVariable String dni, @RequestBody ChefDto chefDto) {
        return this.chefService.updateRecipesFinished(dni, chefDto.getRecipesFinished());
    }

    @GetMapping(SEARCH)
    public Stream<String> findChefsDniThatHaveAKitchenBoyUsingIngredient(@RequestParam String q) {
        System.out.println(q);
        String ingredientName = new LexicalAnalyzer().extractWithAssure(q, "ingredientName");
        return this.chefService.findChefsDniThatHaveAKitchenBoyUsingIngredient(ingredientName);
    }

}
