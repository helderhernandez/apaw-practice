package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDVehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDVehicleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.ArticleEntity;
import es.upm.miw.apaw_practice.adapters.rest.car_dealership.CDBrandDto;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicle;
import es.upm.miw.apaw_practice.domain.models.car_dealership.CDVehicleCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership.CDVehiclePersistence;
import org.springframework.stereotype.Repository;

@Repository("cDVehiclePersistence")
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

}
