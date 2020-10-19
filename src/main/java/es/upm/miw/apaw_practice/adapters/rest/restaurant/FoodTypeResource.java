package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import es.upm.miw.apaw_practice.domain.services.restaurant.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(FoodTypeResource.FOODTYPES)
public class FoodTypeResource {
    static final String FOODTYPES = "/restaurant/foodTypes";

    private FoodTypeService foodTypeService;
    static final String SEARCH = "/search";


    @Autowired
    public FoodTypeResource(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @PatchMapping
    public void updateSpicy(@RequestBody FoodTypeSpicyUpdating spicyUpdating) {
        this.foodTypeService.updateSpicy(spicyUpdating);
    }

    @GetMapping(SEARCH)
    public Stream<FoodTypeDto> findFoodTypesAssociateToOwner(@RequestParam String q) {
        String owner = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.foodTypeService.findFoodTypesAssociateToOwner(owner)
                .map(FoodType::getId)
                .distinct()
                .map(FoodTypeDto::new);
    }
}
