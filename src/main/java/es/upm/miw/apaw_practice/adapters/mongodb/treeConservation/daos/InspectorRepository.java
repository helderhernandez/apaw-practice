package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectorRepository extends MongoRepository<InspectorEntity, String> {
}
