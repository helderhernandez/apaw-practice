package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.DiseaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DiseaseRepository extends MongoRepository<DiseaseEntity, String> {
    Optional<DiseaseEntity> findByName(String name);

    void deleteByName(String name);
}
