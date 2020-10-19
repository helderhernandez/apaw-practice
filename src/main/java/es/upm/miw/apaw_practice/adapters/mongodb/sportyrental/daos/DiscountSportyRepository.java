package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiscountSportyRepository extends MongoRepository<DiscountSportyEntity, String> {
}
