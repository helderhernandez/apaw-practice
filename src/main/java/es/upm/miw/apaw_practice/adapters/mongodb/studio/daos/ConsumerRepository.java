package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.ConsumerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ConsumerRepository extends MongoRepository<ConsumerEntity, String> {
    Optional<ConsumerEntity> findByEmail(String email);
}
