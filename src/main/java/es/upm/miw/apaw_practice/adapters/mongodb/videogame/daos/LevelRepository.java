package es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.LevelEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LevelRepository extends MongoRepository <LevelEntity, String>  {
}
