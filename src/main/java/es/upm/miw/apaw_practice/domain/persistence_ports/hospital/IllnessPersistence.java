package es.upm.miw.apaw_practice.domain.persistence_ports.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Illness;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface IllnessPersistence {
    Stream<Illness> readAll();
    Stream<Illness> readByPhase(Integer phase);
    Illness update(Illness illness);
}
