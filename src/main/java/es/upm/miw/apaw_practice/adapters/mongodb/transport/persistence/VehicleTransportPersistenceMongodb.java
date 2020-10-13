package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.VehicleTransportRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleTransportEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transport.VehicleTransport;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.VehicleTransportPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository("vehicleTransportPersistence")
public class VehicleTransportPersistenceMongodb implements VehicleTransportPersistence {

    private final VehicleTransportRepository vehicleTransportRepository;

    @Autowired
    public VehicleTransportPersistenceMongodb(VehicleTransportRepository vehicleTransportRepository) {
        this.vehicleTransportRepository = vehicleTransportRepository;
    }

    @Override
    public VehicleTransport create(VehicleTransport vehicleTransport) {
        return this.vehicleTransportRepository
                .save(new VehicleTransportEntity(vehicleTransport))
                .toVehicle();
    }

    @Override
    public VehicleTransport readByPlate(String plate) {
        return this.vehicleTransportRepository
                .findByPlate(plate)
                .orElseThrow(() -> new NotFoundException("Plate: " + plate))
                .toVehicle();
    }

    @Override
    public Stream<String> searchDistinctModelListofWorkers(List<String> listofWorkers) {
        return this.vehicleTransportRepository.findAll().stream()
                .filter(vehicle -> listofWorkers.contains(vehicle.getWorkerEntity().getDni()))
                .map(VehicleTransportEntity::toVehicleTransport)
                .map(VehicleTransport::getModel)
                .distinct();
    }
}
