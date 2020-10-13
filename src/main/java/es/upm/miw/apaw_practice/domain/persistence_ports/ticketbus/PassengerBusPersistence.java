package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PassengerBusPersistence {

    Stream<String> findIdJourneysFromNamePassenger(String namePassenger);
}
