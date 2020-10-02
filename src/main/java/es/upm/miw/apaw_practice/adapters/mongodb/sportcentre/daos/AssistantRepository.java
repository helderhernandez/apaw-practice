package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AssistantRepository extends MongoRepository<AssistantEntity, String> {

}
