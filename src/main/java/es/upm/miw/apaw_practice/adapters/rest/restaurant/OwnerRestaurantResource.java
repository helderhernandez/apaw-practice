package es.upm.miw.apaw_practice.adapters.rest.restaurant;

import es.upm.miw.apaw_practice.domain.services.restaurant.OwnerRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(OwnerRestaurantResource.OWNERS)
public class OwnerRestaurantResource {
    static final String OWNERS = "/restaurant/owners";

    static final String OWNERNAME = "/name";

    private OwnerRestaurantService ownerRestaurantService;

    @Autowired
    public OwnerRestaurantResource(OwnerRestaurantService ownerRestaurantService) {
        this.ownerRestaurantService = ownerRestaurantService;
    }

    @GetMapping(OWNERNAME)
    public Stream<NameDto> readName() { return this.ownerRestaurantService.readName()
            .map(NameDto::new); }
}
