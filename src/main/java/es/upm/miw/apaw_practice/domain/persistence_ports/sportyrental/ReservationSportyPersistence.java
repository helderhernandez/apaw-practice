package es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental;


import es.upm.miw.apaw_practice.domain.models.sportyrental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.ReservationCreationSporty;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationSportyPersistence {

    ReservationSporty readByRefReservation(String refReservation);
    ReservationSporty create(ReservationCreationSporty reservationSportyCreation);
}
