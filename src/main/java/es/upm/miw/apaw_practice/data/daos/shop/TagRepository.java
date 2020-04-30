package es.upm.miw.apaw_practice.data.daos.shop;

import es.upm.miw.apaw_practice.data.model.entities.shop.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
}
