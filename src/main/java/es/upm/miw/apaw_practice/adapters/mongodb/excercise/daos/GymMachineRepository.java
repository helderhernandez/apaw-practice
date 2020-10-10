package es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.GymMachineEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GymMachineRepository extends MongoRepository<GymMachineEntity, String> {
    Optional<GymMachineEntity> findByName(String name);
}
