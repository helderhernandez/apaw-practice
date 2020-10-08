package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
    Optional<CustomerEntity> findByDNI(String DNI);
}
