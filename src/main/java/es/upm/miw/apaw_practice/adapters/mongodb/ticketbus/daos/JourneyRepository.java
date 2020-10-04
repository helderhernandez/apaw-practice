package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.JourneyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JourneyRepository extends MongoRepository<JourneyEntity, String> {
}
