package es.upm.miw.apaw_practice.domain.persistence_ports.race;

import es.upm.miw.apaw_practice.domain.models.race.Race;
import org.springframework.stereotype.Repository;

@Repository
public interface RacePersistence {

    Race readById(String id);

    Race updateLocation(String id, String location);

}
