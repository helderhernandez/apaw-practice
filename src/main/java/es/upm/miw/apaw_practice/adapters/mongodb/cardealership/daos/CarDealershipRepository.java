package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CarDealershipEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CarDealershipRepository extends MongoRepository<CarDealershipEntity, String> {
    Optional<CarDealershipEntity> findByName(String name);

}