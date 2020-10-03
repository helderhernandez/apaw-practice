package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<ProductEntity, String> {
    Optional<ProductEntity> findBySerialNumber(Long serialNumber);
}
