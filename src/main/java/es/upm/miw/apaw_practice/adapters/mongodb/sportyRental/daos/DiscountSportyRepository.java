package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.DiscountSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountSportyRepository extends MongoRepository<DiscountSportyEntity, String> {
}
