package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import es.upm.miw.apaw_practice.domain.services.transittaxes.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CarResource.CARS)
public class CarResource {

    static final String CARS = "/transittaxes/cars";
    static final String ID_ID = "/{id}";
    static final String BRAND = "/brand";

    private CarService carService;

    @Autowired
    public CarResource(CarService carService) {
        this.carService = carService;
    }

    @PutMapping(ID_ID + BRAND)
    public Car updateBrand(@PathVariable String id, @RequestBody BrandDto brandDto) {
        return this.carService.updateBrand(id, brandDto.getBrand());
    }
}
