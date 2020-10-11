package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.GymMachineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GymMachineRepository extends MongoRepository<GymMachineEntity, String> {
    Optional<GymMachineEntity> findByName(String name);
}
