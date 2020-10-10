package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.AddressEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface AddressRepository extends MongoRepository<AddressEntity, String> {
    Optional<AddressEntity> findByCountry(String country);
}
