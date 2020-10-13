package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorksRepository extends MongoRepository<WorksEntity, String> {
}
