package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AnimalRepository extends MongoRepository<AnimalEntity, String> {
    Optional<AnimalEntity> findById(String id);
}
