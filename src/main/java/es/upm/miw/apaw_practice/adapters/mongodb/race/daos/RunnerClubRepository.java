package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerClubEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunnerClubRepository extends MongoRepository<RunnerClubEntity, String> {
}
