package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CustomerSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerSportyRepository extends MongoRepository<CustomerSportyEntity, String> {
    Optional<CustomerSportyEntity> findByDni(String dni);
}
