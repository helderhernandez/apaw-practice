package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.TreeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TreeRepository extends MongoRepository<TreeEntity, String> {
}
