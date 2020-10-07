package es.upm.miw.apaw_practice.domain.services.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GameDeveloperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameDeveloperService {

    private GameDeveloperPersistence gameDeveloperPersistence;

    @Autowired
    public GameDeveloperService(GameDeveloperPersistence gameDeveloperPersistence) {
        this.gameDeveloperPersistence = gameDeveloperPersistence;
    }


    public GameDeveloper create(GameDeveloperCreation gameDeveloperCreation) {
        return gameDeveloperPersistence.create(gameDeveloperCreation);
    }

}
