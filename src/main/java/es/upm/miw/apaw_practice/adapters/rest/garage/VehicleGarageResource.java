package es.upm.miw.apaw_practice.adapters.rest.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import es.upm.miw.apaw_practice.domain.services.garage.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(VehicleGarageResource.VEHICLES)
public class VehicleGarageResource {
    static final String VEHICLES = "/garage/vehicles";

    private VehicleService vehicleService;

    @Autowired
    public VehicleGarageResource(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @PatchMapping
    public void updateEstimatedBudget(@RequestBody List<VehicleEstimatedBudgetUpdating> estimatedBudgetUpdatingList){
        this.vehicleService.updateEstimatedBudget(estimatedBudgetUpdatingList);
    }

    @GetMapping
    public Stream<Vehicle> readAll(){
        return this.vehicleService.getAllVehicles();
    }

}
