package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.SurgeryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurgeryRepository extends MongoRepository<SurgeryEntity, String> {
}
