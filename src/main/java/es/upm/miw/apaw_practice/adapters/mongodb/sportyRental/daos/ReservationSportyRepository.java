package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.ReservationSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReservationSportyRepository extends MongoRepository<ReservationSportyEntity, String> {
}
