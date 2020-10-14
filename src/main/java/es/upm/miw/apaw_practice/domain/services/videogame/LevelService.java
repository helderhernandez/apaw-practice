package es.upm.miw.apaw_practice.domain.services.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.LevelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class LevelService {

    private LevelPersistence levelPersistence;

    @Autowired
    public LevelService (LevelPersistence levelPersistence){ this.levelPersistence= levelPersistence; }

    public Stream<Level> readAll() { return levelPersistence.readAll();}

    public Stream<Challenge> findCompletedChallengesByDescription(String description){
        return levelPersistence.findCompletedChallengesByDescription(description);
    }

    public Stream<String> findNickNameByGameDeveloper(String name){
        return levelPersistence.findNickNameByGameDeveloper(name);
    }


}
