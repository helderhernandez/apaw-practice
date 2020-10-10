package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CarDealershipEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarDealershipRepository extends MongoRepository<CarDealershipEntity, String> {
}