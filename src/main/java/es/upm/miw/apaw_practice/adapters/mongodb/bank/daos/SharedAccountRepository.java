package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.SharedAccountEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SharedAccountRepository extends MongoRepository<SharedAccountEntity, String> {
    Optional<SharedAccountEntity> findByIBAN(String IBAN);
}
