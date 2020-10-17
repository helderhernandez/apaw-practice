package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDVehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CDVehicleService {

    private CDVehiclePersistence vehiclePersistence;

    @Autowired
    public CDVehicleService(CDVehiclePersistence vehiclePersistence) {
        this.vehiclePersistence = vehiclePersistence;
    }

    public CDVehicle create(CDVehicleCreation vehicleCreation) {
        return this.vehiclePersistence.create(vehicleCreation);
    }

    public CDVehicle update(CDVehicle vehicle) {
        return this.vehiclePersistence.update(vehicle);
    }

    public CDVehicle updateBrand(String frameNumber, String brand) {
        return this.vehiclePersistence.updateBrand(frameNumber, brand);
    }

    public Stream<String>  findBrandsByEmployeeName(String name) {
        return this.vehiclePersistence.findBrandsByEmployeeName(name);
    }
}
