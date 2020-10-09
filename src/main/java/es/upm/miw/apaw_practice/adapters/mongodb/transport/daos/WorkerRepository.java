package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WorkerRepository extends MongoRepository<WorkerEntity, String> {
    Optional<WorkerEntity> findByDni(String dni);
}
