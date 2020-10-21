package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.TreeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TreeRepository extends MongoRepository<TreeEntity, String> {
}
