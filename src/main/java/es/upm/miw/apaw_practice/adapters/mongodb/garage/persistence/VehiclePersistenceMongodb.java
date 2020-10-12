package es.upm.miw.apaw_practice.adapters.mongodb.garage.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.daos.VehicleGarageRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.VehicleEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("vehiclePersistence")
public class VehiclePersistenceMongodb implements VehiclePersistence {

    private VehicleGarageRepository vehicleGarageRepository;

    @Autowired
    public VehiclePersistenceMongodb(VehicleGarageRepository vehicleGarageRepository){
        this.vehicleGarageRepository = vehicleGarageRepository;
    }


    @Override
    public Vehicle readByCarRegistration(String carRegistration) {
        return vehicleGarageRepository.findByCarRegistration(carRegistration)
                .orElseThrow(() -> new NotFoundException("Vehicle car registration: " + carRegistration))
                .toVehicle();
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        VehicleEntity vehicleEntity = this.vehicleGarageRepository
                .findById(vehicle.getId())
                .orElseThrow(() -> new NotFoundException("Vehicle id: " + vehicle.getId()));
        vehicleEntity.fromVehicle(vehicle);
        return this.vehicleGarageRepository
                .save(vehicleEntity)
                .toVehicle();
    }
}
