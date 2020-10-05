package es.upm.miw.apaw_practice.domain.services.padel;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.PlayerRepository;
import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.PlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerPersistence playerPersistence;

    @Autowired
    public PlayerService(PlayerPersistence playerPersistence) {
        this.playerPersistence = playerPersistence;
    }
    public Player create(PlayerCreation playerCreation){
        return this.playerPersistence.create(playerCreation);
    }
}
