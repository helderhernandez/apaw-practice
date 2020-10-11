package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CarDealership;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CarDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CarDealershipResource.CAR_DEALERSHIPS)
public class CarDealershipResource {
    static final String CAR_DEALERSHIPS = "/car-dealership/car-dealerships";
    static final String NAME = "/{name}";

    private CarDealershipService carDealershipService;

    @Autowired
    public CarDealershipResource(CarDealershipService carDealershipService) {
        this.carDealershipService = carDealershipService;
    }

    @GetMapping(NAME)
    public CarDealership readByName(@PathVariable String name) {
        return this.carDealershipService.readByName(name);
    }

}
