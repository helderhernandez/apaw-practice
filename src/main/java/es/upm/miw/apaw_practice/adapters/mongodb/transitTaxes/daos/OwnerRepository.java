package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.OwnerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OwnerRepository extends MongoRepository<OwnerEntity, String> {
}
