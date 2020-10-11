package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos.ReservationSportyRepository;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyRental.ReservationSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.ReservationSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reservationSportyPersistence")
public class ReservationSportyPersistenceMongodb implements ReservationSportyPersistence {

    private ReservationSportyRepository reservationSportyRepository;

    @Autowired
    public ReservationSportyPersistenceMongodb(ReservationSportyRepository reservationSportyRepository) {
        this.reservationSportyRepository = reservationSportyRepository;
    }

    @Override
    public ReservationSporty readByRefReservation(String refReservation) {
        return this.reservationSportyRepository.findByRefReservation(refReservation)
                .orElseThrow(() -> new NotFoundException("ReservationSporty refReservation:" + refReservation)).convertToReservationSporty();
    }
}
