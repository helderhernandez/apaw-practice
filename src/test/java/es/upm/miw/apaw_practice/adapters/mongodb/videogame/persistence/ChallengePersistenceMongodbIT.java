package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    }
}