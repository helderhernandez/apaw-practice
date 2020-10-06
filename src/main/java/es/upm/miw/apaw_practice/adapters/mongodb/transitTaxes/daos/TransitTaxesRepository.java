package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.TransitTaxesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.VehicleEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TransitTaxesRepository extends MongoRepository<TransitTaxesEntity, String> {
    Optional<TransitTaxesEntity> findByRefTaxes(String ref);
}
