package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.WarehouseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface WarehouseRepository extends MongoRepository<WarehouseEntity, String> {
    Optional<WarehouseEntity> findByName(String name);
}
