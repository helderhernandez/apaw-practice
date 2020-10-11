package es.upm.miw.apaw_practice.adapters.mongodb.videogame;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.ChallengeRepository;
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
    @Autowired
    private ChallengeRepository challengeRepository;


    public void seedDataBase() {
        LogManager.getLogger(this.getClass()).warn("------- Videogame Initial Load -----------");

        ChallengeEntity[] challengeEntities = {
                new ChallengeEntity("Get all red objects", false),
                new ChallengeEntity("Kill all enemies", false),
                new ChallengeEntity("take the flag from the top of the castle ", true)
        };

        this.challengeRepository.saveAll((Arrays.asList(challengeEntities)));

        GameDeveloperEntity[] gameDeveloperEntities = {
                new GameDeveloperEntity("Pedro", "pedrofernandez@hotmail.com", 667659345),
                new GameDeveloperEntity("Alicia", "aliciamartinez@gmail.com", 654331290)
        };

        this.gameDeveloperRepository.saveAll(Arrays.asList(gameDeveloperEntities));

        GamePlayerEntity[] gamePlayerEntities = {
                new GamePlayerEntity("marta06", 10, false, Arrays.asList(challengeEntities[0], challengeEntities[1])),
                new GamePlayerEntity("natcas", 300, true, Arrays.asList(challengeEntities[1], challengeEntities[2])),
                new GamePlayerEntity("martin_db", 50, false, Arrays.asList(challengeEntities[0])),
                new GamePlayerEntity("a89", 200,true,Arrays.asList(challengeEntities[2]))

        };

        this.gamePlayerRepository.saveAll(Arrays.asList(gamePlayerEntities));

        LevelEntity[] levelEntities = {
                new LevelEntity("level 1", 600, 1500, Arrays.asList(gamePlayerEntities[1], gamePlayerEntities[2]), gameDeveloperEntities[0]),
                new LevelEntity("level 2", 1200, 800, Arrays.asList(gamePlayerEntities[1]), gameDeveloperEntities[0]),
                new LevelEntity("level 3", 1800, 500, Arrays.asList(gamePlayerEntities[0], gamePlayerEntities[2]), gameDeveloperEntities[1])

        };

        this.levelRepository.saveAll(Arrays.asList(levelEntities));
    }

    public void deleteAll() {
        this.levelRepository.deleteAll();
        this.gamePlayerRepository.deleteAll();
        this.gameDeveloperRepository.deleteAll();
        this.challengeRepository.deleteAll();
    }
}