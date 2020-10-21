package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectorEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface InspectorRepository extends MongoRepository<InspectorEntity, String> {
    Optional<InspectorEntity> findByDni(String dni);
}
