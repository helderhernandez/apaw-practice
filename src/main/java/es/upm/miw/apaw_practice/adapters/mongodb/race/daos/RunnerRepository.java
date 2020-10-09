package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RunnerRepository extends MongoRepository<RunnerEntity, String> {
}
