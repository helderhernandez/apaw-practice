package es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental;


import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationCreationSporty;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationSportyPersistence {

    ReservationSporty readByRefReservation(String refReservation);
    ReservationSporty create(ReservationCreationSporty reservationSportyCreation);
}
