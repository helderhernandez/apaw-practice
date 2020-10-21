package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectionEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InspectionRepository extends MongoRepository<InspectionEntity, String> {
}
