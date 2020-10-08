package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.OwnerRestaurantEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRestaurantRepository extends MongoRepository<OwnerRestaurantEntity, String> {
}
