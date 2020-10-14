package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.nio.file.NotDirectoryException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class ChallengePersistenceMongodbIT {

    @Autowired
    private ChallengePersistenceMongodb challengePersistence;

    @Test
    void testReadAll(){
        List<Challenge> challengeList = challengePersistence
                .readAll().collect(Collectors.toList());
        assertEquals("Get all red objects",challengeList.get(0).getDescription());
        assertTrue(challengeList.get(2).getCompleted());
    }

    @Test
    void testReadByIdNotFound(){
        assertThrows(NotFoundException.class, () -> challengePersistence.readById("00"));
    }

    @Test
    void testUpdateNotFound(){
        Challenge challenge = new Challenge();
        challenge.setId("01");
        assertThrows(NotFoundException.class, () -> challengePersistence.update(challenge));
    }

    @Test
    void testUpdate(){
        Challenge challenge = challengePersistence.readAll().collect(Collectors.toList()).get(0);
        challenge.setDescription("collect more than 100 coins");
        Challenge updatedChallenge = challengePersistence.update(challenge);
        assertEquals("collect more than 100 coins", updatedChallenge.getDescription());
    }
}