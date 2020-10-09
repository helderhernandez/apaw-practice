package es.upm.miw.apaw_practice.domain.persistence_ports.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDeveloperPersistence {

    GameDeveloper create (GameDeveloperCreation gameDeveloperCreation);

    GameDeveloper updatePhone(String id, Integer phone);
}
