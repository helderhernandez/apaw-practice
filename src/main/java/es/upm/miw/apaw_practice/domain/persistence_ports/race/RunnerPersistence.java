package es.upm.miw.apaw_practice.domain.persistence_ports.race;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerPersistence {

    Runner readById(String id);

    Runner readByDni(String dni);

    Runner update(Runner runner);

}
