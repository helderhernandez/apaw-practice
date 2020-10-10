package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectionRepository extends MongoRepository<InspectionEntity, String> {
}
