package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassengerBusRepository extends MongoRepository<PassengerBusEntity, String> {
}
