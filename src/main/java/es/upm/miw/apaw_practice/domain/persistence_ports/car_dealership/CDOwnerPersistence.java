package es.upm.miw.apaw_practice.domain.persistence_ports.car_dealership;

import java.util.stream.Stream;

public interface CDOwnerPersistence {
    Stream<String> findOwnerByBrand(String brand);
}
