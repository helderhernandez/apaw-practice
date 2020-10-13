package es.upm.miw.apaw_practice.domain.services.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDBrandDto;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDVehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
