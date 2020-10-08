package es.upm.miw.apaw_practice.domain.persistence_ports.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MechanicPersistence {

    Stream<Mechanic> readAll();

}
