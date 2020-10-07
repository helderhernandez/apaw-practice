package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence.VehiclePersistenceMongodb;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import es.upm.miw.apaw_practice.domain.models.transport.Vehicle;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.services.transport.VehicleService;
import es.upm.miw.apaw_practice.domain.services.transport.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VehicleResource.VEHICLES)
public class VehicleResource {
    static final String VEHICLES = "/transport/vehicles";

    private VehicleService vehicleService;

    @Autowired
    public VehicleResource(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public Vehicle create(@RequestBody Vehicle vehicle) {
        return this.vehicleService.create(vehicle);
    }

}
