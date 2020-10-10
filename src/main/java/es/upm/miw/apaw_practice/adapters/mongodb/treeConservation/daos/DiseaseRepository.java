package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.DiseaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseRepository extends MongoRepository<DiseaseEntity, String> {
}
