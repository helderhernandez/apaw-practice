package es.upm.miw.apaw_practice.domain.persistence_ports.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Car;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CarPersistence {
    Car updateBrand(String id, String brand);
    Stream<Car> readAll();
}
