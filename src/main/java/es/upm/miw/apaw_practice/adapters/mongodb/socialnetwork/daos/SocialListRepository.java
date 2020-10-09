package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialListEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocialListRepository extends MongoRepository<SocialListEntity, String> {
}
