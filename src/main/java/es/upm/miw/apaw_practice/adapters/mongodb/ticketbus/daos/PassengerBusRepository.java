package es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.ticketbus.entities.PassengerBusEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.stream.Stream;

public interface PassengerBusRepository extends MongoRepository<PassengerBusEntity, String> {
    Stream<PassengerBusEntity> findAllByName(String name);
}
