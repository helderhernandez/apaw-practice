package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialTrendEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SocialTrendRepository extends MongoRepository<SocialTrendEntity, String> {
}
