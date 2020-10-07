package es.upm.miw.apaw_practice.adapters.mongodb.property.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProprietorRepository extends MongoRepository<ProprietorEntity,String> {
    Optional<ProprietorEntity> findByDni(String dni);
}
