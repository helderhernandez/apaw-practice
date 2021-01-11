package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.DesignEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesignRepository extends MongoRepository<DesignEntity, String> {
}
