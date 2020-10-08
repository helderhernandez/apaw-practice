package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleTransportEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleTransportRepository extends MongoRepository<VehicleTransportEntity, String> {
    Optional<VehicleTransportEntity> findByPlate(String plate);

}
