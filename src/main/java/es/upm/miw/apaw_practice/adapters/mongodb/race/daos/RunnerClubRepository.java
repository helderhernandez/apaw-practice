package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerClubEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RunnerClubRepository extends MongoRepository<RunnerClubEntity, String> {

    Optional<RunnerClubEntity> findByName(String name);

}
