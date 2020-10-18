package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RaceRepository extends MongoRepository<RaceEntity, String> {

    List<RaceEntity> findByName(String name);

}
