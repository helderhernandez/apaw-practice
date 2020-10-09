package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.DepartmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.VehicleTransportEntity;
import es.upm.miw.apaw_practice.domain.models.transport.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DepartmentRepository extends MongoRepository<DepartmentEntity, String> {
    Optional<DepartmentEntity> findByName(String name);
}
