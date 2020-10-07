package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos.VehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.VehicleEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Vehicle;
import es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes.VehiclePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("VehiclePersistence")
public class VehiclePersistenceMongodb implements VehiclePersistence {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehiclePersistenceMongodb(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public Vehicle updateBrand(String id, String brand) {
        VehicleEntity vehicleEntity = vehicleRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Vehicle id: " + id));
        vehicleEntity.setBrand(brand);
        return vehicleRepository.save(vehicleEntity).toVehicle();
    }

    @Override
    public Stream<Vehicle> readAll() {
        return this.vehicleRepository.findAll().stream()
                .map(VehicleEntity::toVehicle);
    }

}
