package es.upm.miw.apaw_practice.domain.persistence_ports.padel;

import es.upm.miw.apaw_practice.domain.models.Reservation.Reservation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ReservationPersistence {
    Stream<Reservation> readAll();
}
