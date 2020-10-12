package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DiseaseRepository extends MongoRepository<DiseaseEntity, String> {
    Optional<DiseaseEntity> findByName(String name);
}
