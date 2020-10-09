package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.FoodTypeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodTypeRepository extends MongoRepository<FoodTypeEntity, String>  {

}
