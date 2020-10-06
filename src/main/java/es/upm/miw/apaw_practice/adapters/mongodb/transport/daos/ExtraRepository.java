package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExtraRepository extends MongoRepository<ExtraEntity, String> {
}
