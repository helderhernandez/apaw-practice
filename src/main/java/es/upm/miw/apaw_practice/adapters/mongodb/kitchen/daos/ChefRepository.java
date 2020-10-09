package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.ChefEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ChefRepository extends MongoRepository<ChefEntity, String> {
    Optional<ChefEntity> findByDni(String dni);

}
