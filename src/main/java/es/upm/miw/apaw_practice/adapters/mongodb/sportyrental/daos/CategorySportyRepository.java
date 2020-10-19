package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CategorySportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorySportyRepository extends MongoRepository<CategorySportyEntity, String> {
}
