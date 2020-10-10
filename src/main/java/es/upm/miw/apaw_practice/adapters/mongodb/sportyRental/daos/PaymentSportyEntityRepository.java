package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.PaymentSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentSportyEntityRepository extends MongoRepository<PaymentSportyEntity, String> {
}
