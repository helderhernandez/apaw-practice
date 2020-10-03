package es.upm.miw.apaw_practice.adapters.mongodb.bank.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.ShareholderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShareholderRepository extends MongoRepository<ShareholderEntity, String> {
}
