package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MechanicRepository extends MongoRepository<MechanicEntity, String> {

}
