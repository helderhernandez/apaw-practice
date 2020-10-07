package es.upm.miw.apaw_practice.adapters.mongodb.property.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyCompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PropertyCompanyRepository extends MongoRepository<PropertyCompanyEntity,String> {
    Optional<PropertyCompanyEntity> findByName(String name);
}
