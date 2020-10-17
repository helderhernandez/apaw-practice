package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDVehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CarDealershipRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDVehicleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CarDealershipEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDVehiclePersistence;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Stream;

@Repository("cDVehiclePersistence")
public class CDVehiclePersistenceMongodb implements CDVehiclePersistence {

    private CDVehicleRepository vehicleRepository;
    private CarDealershipRepository carDealershipRepository;

    public CDVehiclePersistenceMongodb(CDVehicleRepository vehicleRepository, CarDealershipRepository carDealershipRepository) {
        this.vehicleRepository = vehicleRepository;
        this.carDealershipRepository = carDealershipRepository;
    }

    @Override
    public CDVehicle create(CDVehicleCreation vehicleCreation) {
        return this.vehicleRepository
                .save(new CDVehicleEntity(vehicleCreation))
                .toVehicle();
    }

    @Override
    public CDVehicle update(CDVehicle vehicle) {
        CDVehicleEntity vehicleEntity = this.vehicleRepository
                .findById(vehicle.getId())
                .orElseThrow(() -> new NotFoundException("Article id: " + vehicle.getId()));
        vehicleEntity.fromVehicle(vehicle);
        return this.vehicleRepository
                .save(vehicleEntity)
                .toVehicle();
    }

    @Override
    public CDVehicle updateBrand(String frameNumber, String brand) {
        CDVehicleEntity vehicleEntity = this.vehicleRepository
                .findByFrameNumber(frameNumber)
                .orElseThrow(() -> new NotFoundException("Frame number: " + frameNumber));
        vehicleEntity.setBrand(brand);
        return this.vehicleRepository.save(vehicleEntity).toVehicle();
    }

    @Override
    public Stream<String> findBrandsByEmployeeName(String name) {
        return this.carDealershipRepository.findAll()
                .stream()
                .filter(item -> item.getEmployees().stream()
                        .anyMatch(cdEmployeeEntity -> cdEmployeeEntity.getName().equals(name)))
                .map(CarDealershipEntity::getVehicles)
                .flatMap(Collection::stream)
                .map(CDVehicleEntity::toVehicle)
                .map(CDVehicle::getBrand);
    }
}
