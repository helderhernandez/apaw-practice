package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameDeveloperRepository extends MongoRepository<GameDeveloperEntity, String> {
}
