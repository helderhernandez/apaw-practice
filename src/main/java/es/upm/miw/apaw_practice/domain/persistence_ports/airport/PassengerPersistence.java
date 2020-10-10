package es.upm.miw.apaw_practice.domain.persistence_ports.airport;

import es.upm.miw.apaw_practice.domain.models.airport.Passenger;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PassengerPersistence {

    void delete(String id);

    Stream<Passenger> findDistinctNameUserByModelPlane(String modelPlane);
}
