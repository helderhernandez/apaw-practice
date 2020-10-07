package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TransitTaxesEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TransitTaxesRepository extends MongoRepository<TransitTaxesEntity, String> {
    Optional<TransitTaxesEntity> findByRefTaxes(String ref);
}
