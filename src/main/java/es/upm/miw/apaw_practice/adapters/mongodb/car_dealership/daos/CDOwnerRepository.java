package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CDOwnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CDOwnerRepository extends MongoRepository<CDOwnerEntity, String> {
}
