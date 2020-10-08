package es.upm.miw.apaw_practice.adapters.rest.kitchen;

import es.upm.miw.apaw_practice.domain.models.kitchen.Chef;
import es.upm.miw.apaw_practice.domain.services.kitchen.ChefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ChefResource.CHEF)
public class ChefResource {
    static final String CHEF = "/kitchen/chef";
    static final String DNI = "/{dni}";
    static final String RECIPES_FINISHED = "/recipesFinished";

    private ChefService chefService;

    @Autowired
    public ChefResource(ChefService chefService) {
        this.chefService = chefService;
    }

    @PutMapping(DNI + RECIPES_FINISHED)
    public Chef updateRecipesFinished(@PathVariable ChefDto chefDto) {
        return this.chefService.updateRecipesFinished(chefDto.getDni(), chefDto.getRecipesFinished());
    }

}
