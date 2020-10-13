package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.EssayEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EssayRepository extends MongoRepository<EssayEntity, String> {
}
