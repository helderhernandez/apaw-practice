package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CategoryCreationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CategorySporty;
import es.upm.miw.apaw_practice.domain.services.sportyRental.CategorySportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CategorySportyResource.CATEGORIES_SPORTY)
public class CategorySportyResource {

    static final String CATEGORIES_SPORTY = "/sportyRental/categories";
    static final String ID_CATEGORY = "/{idCategory}";

    private CategorySportyService categorySportyService;

    @Autowired
    public CategorySportyResource(CategorySportyService categorySportyService) {
        this.categorySportyService = categorySportyService;
    }

    @PutMapping(path = ID_CATEGORY)
    public CategorySporty update(@PathVariable String idCategory, @RequestBody CategoryCreationSporty categorySportyCreation) {
        return this.categorySportyService.update(idCategory, categorySportyCreation);
    }
}
