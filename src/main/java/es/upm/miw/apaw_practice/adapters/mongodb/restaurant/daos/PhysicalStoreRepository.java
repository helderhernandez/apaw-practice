package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.PhysicalStoreEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PhysicalStoreRepository extends MongoRepository<PhysicalStoreEntity, String> {
    Optional<PhysicalStoreEntity> findByAddress(String address);
}
