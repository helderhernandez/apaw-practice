package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.shop.entities.TagEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CDEmployeeRepository extends MongoRepository<TagEntity, String> {
}