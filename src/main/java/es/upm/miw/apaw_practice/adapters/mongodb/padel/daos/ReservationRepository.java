package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.ReservationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends MongoRepository<ReservationEntity,String> {
    Optional<List<ReservationEntity>> findAllByDateBefore(LocalDateTime date);
}
