package es.upm.miw.apaw_practice.domain.persistence_ports.ticketbus;

import es.upm.miw.apaw_practice.domain.models.ticketbus.Journey;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface JourneyPersistence {

    Stream<Journey> findAll();
}
