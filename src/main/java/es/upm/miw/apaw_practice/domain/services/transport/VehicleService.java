package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleService {

    private VehiclePersistence vehiclePersistence;

    @Autowired
    public VehicleService(VehiclePersistence vehiclePersistence) {
        this.vehiclePersistence = vehiclePersistence;
    }

    public Vehicle create(Vehicle vehicle) {
        return this.vehiclePersistence.create(vehicle);
    }
}
