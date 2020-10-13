package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface TaxRepository extends MongoRepository<TaxEntity, String> {
    Optional<TaxEntity> findByRefTax(String ref);
}
