package es.upm.miw.apaw_practice.domain.services.videogame;

import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GamePlayerPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.LevelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class GamePlayerService {

    private GamePlayerPersistence gamePlayerPersistence;
    private LevelPersistence levelPersistence;

    public GamePlayerService(GamePlayerPersistence gamePlayerPersistence, LevelPersistence levelPersistence) {
        this.gamePlayerPersistence = gamePlayerPersistence;
        this.levelPersistence = levelPersistence;
    }

    public void delete(String id){
        gamePlayerPersistence.delete(id);
    }

    public Stream<String> findNickNameByGameDeveloper(String name){
        return levelPersistence.findNickNameByGameDeveloper(name);
    }
}
