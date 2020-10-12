package es.upm.miw.apaw_practice.domain.persistence_ports.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiclePersistence {

    Vehicle readByCarRegistration(String carRegistration);

    Vehicle update(Vehicle vehicle);
}
