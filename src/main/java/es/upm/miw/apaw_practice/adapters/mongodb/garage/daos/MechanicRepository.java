package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MechanicRepository extends MongoRepository<MechanicEntity, String> {
    Optional<List<MechanicEntity>> findByDepartment(String department);
}
