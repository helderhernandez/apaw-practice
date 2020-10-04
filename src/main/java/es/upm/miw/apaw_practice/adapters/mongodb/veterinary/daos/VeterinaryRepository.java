package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.VeterinaryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VeterinaryRepository extends MongoRepository<VeterinaryEntity, String> {
}
