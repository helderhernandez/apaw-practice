package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.ReservationSportyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ReservationSportyRepository extends MongoRepository<ReservationSportyEntity, String> {
    Optional<ReservationSportyEntity> findByRefReservation(String refReservation);
}
