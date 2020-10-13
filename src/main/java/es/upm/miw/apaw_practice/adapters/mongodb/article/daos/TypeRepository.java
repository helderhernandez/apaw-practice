package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.TypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepository extends MongoRepository<TypeEntity, String> {
}
