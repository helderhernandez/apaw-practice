package es.upm.miw.apaw_practice.domain.services.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationCreationSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.ReservationSportyPersistence;
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
