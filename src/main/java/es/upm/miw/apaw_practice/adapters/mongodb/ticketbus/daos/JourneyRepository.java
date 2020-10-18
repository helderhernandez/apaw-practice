package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface JourneyRepository extends MongoRepository<JourneyEntity, String> {
    Optional<JourneyEntity> findByDepartureAndArrive(String departure, String arrive);
}
