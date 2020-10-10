package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CategorySportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategorySportyRepository extends MongoRepository<CategorySportyEntity, String> {
}
