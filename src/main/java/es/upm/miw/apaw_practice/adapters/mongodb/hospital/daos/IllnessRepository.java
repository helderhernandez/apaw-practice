package es.upm.miw.apaw_practice.adapters.mongodb.hospital.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.hospital.entities.IllnessEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface IllnessRepository extends MongoRepository<IllnessEntity, String> {
    Optional<List<IllnessEntity>> findByContagious(Boolean contagious);
    List<IllnessEntity> findByPhase(Integer phase);

}
