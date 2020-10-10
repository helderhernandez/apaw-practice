package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.ReservationSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReservationSportyRepository extends MongoRepository<ReservationSportyEntity, String> {
    Optional<ReservationSportyEntity> findByRefReservation(String refReservation);
}
