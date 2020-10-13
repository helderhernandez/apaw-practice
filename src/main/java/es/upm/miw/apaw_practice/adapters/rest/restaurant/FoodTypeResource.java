package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.FoodTypeSpicyUpdating;
import es.upm.miw.apaw_practice.domain.services.restaurant.FoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FoodTypeResource.FOODTYPES)
public class FoodTypeResource {
    static final String FOODTYPES = "/restaurant/foodTypes";

    private FoodTypeService foodTypeService;

    @Autowired
    public FoodTypeResource(FoodTypeService foodTypeService) {
        this.foodTypeService = foodTypeService;
    }

    @PatchMapping
    public void updateSpicy(@RequestBody FoodTypeSpicyUpdating spicyUpdating) {
        this.foodTypeService.updateSpicy(spicyUpdating);
    }
}
