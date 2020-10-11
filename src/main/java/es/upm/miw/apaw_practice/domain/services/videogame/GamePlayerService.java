package es.upm.miw.apaw_practice.domain.services.videogame;

import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GamePlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GamePlayerService {

    private GamePlayerPersistence gamePlayerPersistence;

    public GamePlayerService(GamePlayerPersistence gamePlayerPersistence) {
        this.gamePlayerPersistence = gamePlayerPersistence;
    }

    public void delete(String id){
        gamePlayerPersistence.delete(id);
    }
}
