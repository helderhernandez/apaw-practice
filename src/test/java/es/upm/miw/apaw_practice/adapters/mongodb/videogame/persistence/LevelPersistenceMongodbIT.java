package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import org.assertj.core.util.VisibleForTesting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class LevelPersistenceMongodbIT {

    @Autowired
    private LevelPersistenceMongodb levelPersistence;

    @Test
    void testReadAll() {
        List<Level> levelList = levelPersistence
                .readAll().collect(Collectors.toList());
        assertEquals(3, levelList.size());
        assertEquals("level 2", levelList.get(1).getDescription());
        assertEquals("martin_db", levelList.get(2).getGamePlayerList().get(1).getNickName());
    }

    @Test
    void testFindCompletedChallengesByDescription(){
        List<Challenge> challengeList = levelPersistence
                .findCompletedChallengesByDescription("level 1")
                .collect(Collectors.toList());

        assertEquals("take the flag from the top of the castle ", challengeList.get(0).getDescription());

    }

}