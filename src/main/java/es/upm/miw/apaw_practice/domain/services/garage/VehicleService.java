package es.upm.miw.apaw_practice.domain.services.garage;

import es.upm.miw.apaw_practice.adapters.rest.garage.VehicleEstimatedBudgetUpdating;
import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class VehicleService {

    private VehiclePersistence vehiclePersistence;

    @Autowired
    public VehicleService(VehiclePersistence vehiclePersistence) {
        this.vehiclePersistence = vehiclePersistence;
    }

    public void updateEstimatedBudget(List<VehicleEstimatedBudgetUpdating> estimatedBudgetUpdatingList){
        estimatedBudgetUpdatingList.stream()
                .map(vehicleNewBudget -> {
                    Vehicle vehicle = this.vehiclePersistence.readByCarRegistration(vehicleNewBudget.getCarRegistration());
                    vehicle.setEstimatedBudget(vehicleNewBudget.getEstimatedBudget());
                    return vehicle;
                })
                .forEach(vehicle -> this.vehiclePersistence.update(vehicle));
    }

    public Stream<Vehicle> getAllVehicles(){
        return vehiclePersistence.readAll();
    }

}
