package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurant;
import es.upm.miw.apaw_practice.domain.models.restaurant.OwnerRestaurantUpdate;
import es.upm.miw.apaw_practice.domain.services.restaurant.OwnerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(OwnerRestaurantResource.OWNERS)
public class OwnerRestaurantResource {
    static final String OWNERS = "/restaurant/owners";

    static final String OWNERNAME = "/name";
    static final String ID_ID = "/{id}";

    private OwnerRestaurantService ownerRestaurantService;

    @Autowired
    public OwnerRestaurantResource(OwnerRestaurantService ownerRestaurantService) {
        this.ownerRestaurantService = ownerRestaurantService;
    }

    @GetMapping(OWNERNAME)
    public Stream<NameDto> readName() {
        return this.ownerRestaurantService.readName()
                .map(NameDto::new);
    }

    @PutMapping(ID_ID)
    public OwnerRestaurant updateOwner(@PathVariable String id, @RequestBody OwnerRestaurantUpdate ownerRestaurantUpdate) {
        return this.ownerRestaurantService.updateOwner(id, ownerRestaurantUpdate);
    }
}
