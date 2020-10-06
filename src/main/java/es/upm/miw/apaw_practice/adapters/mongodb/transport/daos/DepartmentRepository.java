package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.DepartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {
}
