package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.DegreeEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface DegreeRepository extends MongoRepository<DegreeEntity, String> {
    Optional<DegreeEntity> findByRecordNumber(String recordNumber);
}
