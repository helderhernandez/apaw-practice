package es.upm.miw.apaw_practice.domain.persistence_ports.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerPersistence {
    Player create(PlayerCreation playerCreation);
}
