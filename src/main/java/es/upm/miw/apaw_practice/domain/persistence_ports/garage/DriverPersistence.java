package es.upm.miw.apaw_practice.domain.persistence_ports.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Driver;
import es.upm.miw.apaw_practice.domain.models.garage.DriverCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface DriverPersistence {
    Driver create (DriverCreation driverCreation);

    void delete (String dni);

    Stream<String> findMechanicNamesByDriverName(String driverName);
}
