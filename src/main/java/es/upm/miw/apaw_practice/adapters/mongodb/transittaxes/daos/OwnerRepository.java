package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.OwnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface OwnerRepository extends MongoRepository<OwnerEntity, String> {
    Optional<OwnerEntity> findByDni(String dni);
}
