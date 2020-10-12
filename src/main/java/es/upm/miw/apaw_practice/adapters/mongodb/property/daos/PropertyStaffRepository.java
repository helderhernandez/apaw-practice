package es.upm.miw.apaw_practice.adapters.mongodb.property.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PropertyStaffRepository extends MongoRepository<PropertyStaffEntity,String> {
    Optional<PropertyStaffEntity> findByDni(String dni);
}
