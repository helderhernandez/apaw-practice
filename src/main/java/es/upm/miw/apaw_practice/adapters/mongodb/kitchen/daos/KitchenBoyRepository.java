package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.KitchenBoyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KitchenBoyRepository extends MongoRepository<KitchenBoyEntity, String> {
    Optional<KitchenBoyEntity> findByDni(String dni);
}
