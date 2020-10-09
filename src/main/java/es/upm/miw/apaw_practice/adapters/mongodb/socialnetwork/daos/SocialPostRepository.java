package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialPostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocialPostRepository extends MongoRepository<SocialPostEntity, String> {
}
