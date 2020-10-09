package es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDOwnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CDOwnerRepository extends MongoRepository<CDOwnerEntity, String> {
}
