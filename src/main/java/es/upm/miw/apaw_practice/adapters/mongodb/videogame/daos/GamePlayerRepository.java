package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GamePlayerRepository extends MongoRepository<GamePlayerEntity, String> {
}
