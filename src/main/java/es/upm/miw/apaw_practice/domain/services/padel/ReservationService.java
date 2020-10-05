package es.upm.miw.apaw_practice.domain.services.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Reservation;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.ReservationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ReservationService {
    private ReservationPersistence reservationPersistence;

    @Autowired
    public ReservationService(ReservationPersistence reservationPersistence){
        this.reservationPersistence = reservationPersistence;
    }

    public Stream<Reservation> readAll() {
        return this.reservationPersistence.readAll();
    }

}
