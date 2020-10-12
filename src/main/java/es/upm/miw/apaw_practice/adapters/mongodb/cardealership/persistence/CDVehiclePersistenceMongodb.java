package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDVehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDVehicleEntity;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDVehiclePersistence;
import org.springframework.stereotype.Repository;

@Repository("vehiclePersistence")
public class CDVehiclePersistenceMongodb implements CDVehiclePersistence {

    private CDVehicleRepository vehicleRepository;

    public CDVehiclePersistenceMongodb(CDVehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public CDVehicle create(CDVehicleCreation vehicleCreation) {
        return this.vehicleRepository
                .save(new CDVehicleEntity(vehicleCreation))
                .toVehicle();
    }
}
