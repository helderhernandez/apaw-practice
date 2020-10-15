package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import es.upm.miw.apaw_practice.domain.services.garage.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(DriverResource.DRIVERS)
public class DriverResource {
    static final String DRIVERS = "/garage/drivers";
    static final String ID_DNI= "/{dni}";
    static final String SEARCH = "/search";

    private DriverService driverService;

    @Autowired
    public DriverResource(DriverService driverService){
        this.driverService = driverService;
    }

    @PostMapping
    public Driver create(@RequestBody DriverCreation driverCreation){
        return this.driverService.create(driverCreation);
    }

    @DeleteMapping(ID_DNI)
    public void delete(@PathVariable String dni){
        this.driverService.delete(dni);
    }

    @GetMapping(SEARCH)
    public List<String> findMechanicNamesByDriverName(@RequestParam String q) {
        String driverName = new LexicalAnalyzer().extractWithAssure(q, "driver");
        return this.driverService.findMechanicNamesByDriverName(driverName);
    }

}
