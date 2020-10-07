package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Bed;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface BedPersistence {
    Bed updateOccupied(String id, Boolean occupied);

    Stream<String> findByNameWidthOfBeds(String name);
}
