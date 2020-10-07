package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface VehiclePersistence {
    Vehicle updateBrand(String id, String brand);
    Stream<Vehicle> readAll();
}
