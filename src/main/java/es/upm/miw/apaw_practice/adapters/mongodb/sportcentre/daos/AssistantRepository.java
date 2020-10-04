package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.InstructorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AssistantRepository extends MongoRepository<AssistantEntity, String> {
    Optional<AssistantEntity> findById(String id);
}
