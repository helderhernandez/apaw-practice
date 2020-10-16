package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RunnerRepository extends MongoRepository<RunnerEntity, String> {

    Optional<RunnerEntity> findByDni(String dni);

}
