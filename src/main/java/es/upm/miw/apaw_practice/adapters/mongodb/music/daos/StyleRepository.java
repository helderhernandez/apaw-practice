package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.StyleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface StyleRepository extends MongoRepository<StyleEntity,String> {
    Optional<StyleEntity> findByName(String name);
}
