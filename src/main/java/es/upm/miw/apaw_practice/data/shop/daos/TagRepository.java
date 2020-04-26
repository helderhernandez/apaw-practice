package es.upm.miw.apaw_practice.data.shop.daos;

import es.upm.miw.apaw_practice.data.shop.entities.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<Tag, String> {
}
