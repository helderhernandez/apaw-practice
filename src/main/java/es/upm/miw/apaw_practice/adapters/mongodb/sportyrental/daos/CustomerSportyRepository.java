package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.CustomerSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerSportyRepository extends MongoRepository<CustomerSportyEntity, String> {
    Optional<CustomerSportyEntity> findByDni(String dni);
}
