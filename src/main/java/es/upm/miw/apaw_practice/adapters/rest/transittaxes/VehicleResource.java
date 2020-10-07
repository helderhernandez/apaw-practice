package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Vehicle;
import es.upm.miw.apaw_practice.domain.services.transittaxes.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VehicleResource.VEHICLES)
public class VehicleResource {
    static final String VEHICLES = "/transittaxes/vehicles";
    static final String ID_ID = "/{id}";
    static final String BRAND = "/brand";

    private VehicleService vehicleService;

    @Autowired
    public VehicleResource(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PutMapping(ID_ID + BRAND)
    public Vehicle updateBrand(@PathVariable String id, @RequestBody BrandDto brandDto) {
        return this.vehicleService.updateBrand(id, brandDto.getBrand());
    }
}
