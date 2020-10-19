package es.upm.miw.apaw_practice.domain.services.sportyrental;

import es.upm.miw.apaw_practice.domain.models.sportyrental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyrental.ReservationCreationSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyrental.ReservationSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationSportyService {

    private ReservationSportyPersistence reservationSportyPersistence;

    @Autowired
    public ReservationSportyService(ReservationSportyPersistence reservationSportyPersistence) {
        this.reservationSportyPersistence = reservationSportyPersistence;
    }

    public ReservationSporty readByRefReservation(String refReservation) {
        return this.reservationSportyPersistence.readByRefReservation(refReservation);
    }

    public ReservationSporty create(ReservationCreationSporty reservationSportyCreation) {
        return this.reservationSportyPersistence.create(reservationSportyCreation);
    }
}
