package es.upm.miw.apaw_practice.adapters.mongodb.padel.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.ReservationRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.ReservationEntity;
import es.upm.miw.apaw_practice.domain.models.Reservation.Reservation;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.ReservationPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("reservationPersistence")
public class ReservationPersistenceMongodb implements ReservationPersistence {

    private ReservationRepository reservationRepository;

    public ReservationPersistenceMongodb(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Autowired


    @Override
    public Stream<Reservation> readAll() {
        return this.reservationRepository.findAll().stream()
                .map(ReservationEntity::toReservation);
    }
}
