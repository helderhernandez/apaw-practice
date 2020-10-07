package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LikesRepository extends MongoRepository<LikesEntity, String> {
}
