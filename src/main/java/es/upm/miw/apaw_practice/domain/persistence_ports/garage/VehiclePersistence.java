package es.upm.miw.apaw_practice.domain.persistence_ports.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface VehiclePersistence {

    Vehicle readByCarRegistration(String carRegistration);

    Vehicle update(Vehicle vehicle);

    Stream<Vehicle> readAll();

    Stream<String> findPieceBarcodeByMechanicName(String mechanicName);
}
