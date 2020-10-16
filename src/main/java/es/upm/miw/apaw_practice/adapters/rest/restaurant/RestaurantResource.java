package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.restaurant.FoodType;
import es.upm.miw.apaw_practice.domain.models.restaurant.Restaurant;
import es.upm.miw.apaw_practice.domain.services.restaurant.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(RestaurantResource.RESTAURANTS)
public class RestaurantResource {
    static final String RESTAURANTS = "/restaurants";

    static final String SEARCH = "/search";
    static final String FOODTYPES = "/foodTypes";

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantResource(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping(FOODTYPES + SEARCH)
    public Stream<String> findFoodTypesAssociateToOwner(@PathVariable String q) {
        String owner = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.restaurantService.findFoodTypesAssociateToOwner(owner);
    }
}
