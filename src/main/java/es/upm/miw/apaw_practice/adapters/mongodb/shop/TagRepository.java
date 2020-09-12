package es.upm.miw.apaw_practice.adapters.mongodb.shop;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<TagEntity, String> {
}
