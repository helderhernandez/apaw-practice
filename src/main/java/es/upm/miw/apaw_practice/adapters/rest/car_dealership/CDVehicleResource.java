package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CDVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CDVehicleResource.VEHICLES)
public class CDVehicleResource {
    static final String VEHICLES = "/car-dealership/vehicles";

    private CDVehicleService vehicleService;

    @Autowired
    public CDVehicleResource(CDVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public CDVehicle create(@RequestBody CDVehicleCreation vehicleCreation) {
        return this.vehicleService.create(vehicleCreation);
    }
}
