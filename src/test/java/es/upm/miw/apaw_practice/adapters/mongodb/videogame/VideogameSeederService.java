package es.upm.miw.apaw_practice.adapters.mongodb.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GameDeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.LevelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.ChallengeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.LevelEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class VideogameSeederService {

    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;
    @Autowired
    private GamePlayerRepository gamePlayerRepository;
    @Autowired
    private LevelRepository levelRepository;


    public void seedDataBase() {
        LogManager.getLogger(this.getClass()).warn("------- Videogame Initial Load -----------");
        ChallengeEntity[] challengeEntities = {
                new ChallengeEntity("Get all red objects", false),
                new ChallengeEntity("Kill all enemies", false),
                new ChallengeEntity("take the flag from the top of the castle ", true)
        };

        GameDeveloperEntity[] gameDeveloperEntities = {
                new GameDeveloperEntity("Pedro", "pedrofernandez@hotmail.com", 667659345),
                new GameDeveloperEntity("Alicia", "aliciamartinez@gmail.com", 654331290)
        };

        this.gameDeveloperRepository.saveAll(Arrays.asList(gameDeveloperEntities));

        GamePlayerEntity[] gamePlayerEntities ={
                new GamePlayerEntity("marta06", 10, false, Arrays.asList(challengeEntities[0], challengeEntities[1]) ),
                new GamePlayerEntity("natcas", 300, true, Arrays.asList(challengeEntities[1],challengeEntities[2])),
                new GamePlayerEntity("martin_db", 50, false, Arrays.asList(challengeEntities[0]))
        };

        this.gamePlayerRepository.saveAll(Arrays.asList(gamePlayerEntities));

        LevelEntity [] levelEntities = {
                new LevelEntity("level 1", 600, 1500,Arrays.asList(gamePlayerEntities[1],gamePlayerEntities[2]), gameDeveloperEntities[0] ),

        };



    }

    public void deleteAll() {
    }
}
