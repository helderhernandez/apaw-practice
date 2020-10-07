package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.VehicleReopsitory;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleEntity;
import es.upm.miw.apaw_practice.domain.models.transport.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vehiclePersistence")
public class VehiclePersistenceMongodb implements VehiclePersistence {

    private VehicleReopsitory vehicleReopsitory;

    @Autowired
    public VehiclePersistenceMongodb(VehicleReopsitory vehicleReopsitory) {
        this.vehicleReopsitory = vehicleReopsitory;
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return this.vehicleReopsitory
                .save(new VehicleEntity(vehicle))
                .toVehicle();
    }
}
