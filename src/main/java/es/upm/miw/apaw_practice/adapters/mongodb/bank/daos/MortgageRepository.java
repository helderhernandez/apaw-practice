package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.MortgageEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MortgageRepository extends MongoRepository<MortgageEntity, String> {
}
