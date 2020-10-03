package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<EmployeeEntity, String> {
    Optional<EmployeeEntity> findByDni(String dni);
}
