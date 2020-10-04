package es.upm.miw.apaw_practice.adapters.mongodb.project.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DeveloperRepository extends MongoRepository<DeveloperEntity, String> {
    Optional<DeveloperEntity> findByEmail(String email);
}
