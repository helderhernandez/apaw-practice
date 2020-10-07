package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VehicleReopsitory extends MongoRepository<VehicleEntity, String> {

}
