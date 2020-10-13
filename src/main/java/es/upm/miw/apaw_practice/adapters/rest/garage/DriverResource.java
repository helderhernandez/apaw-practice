package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import es.upm.miw.apaw_practice.domain.services.garage.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DriverResource.DRIVERS)
public class DriverResource {
    static final String DRIVERS = "/garage/drivers";

    private DriverService driverService;

    @Autowired
    public DriverResource(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping
    public Driver create(@RequestBody DriverCreation driverCreation){
        return this.driverService.create(driverCreation);
    }

}
