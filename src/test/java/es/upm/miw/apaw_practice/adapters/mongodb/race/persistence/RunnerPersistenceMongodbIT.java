package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.race.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RunnerPersistenceMongodbIT {

    @Autowired
    private RunnerPersistenceMongodb runnerPersistenceMongodb;

    @Test
    void testReadById() {
        Runner runner = runnerPersistenceMongodb.readById("2");
        assertEquals("Maria", runner.getName());
        assertTrue(runner.getProfessional());
        assertEquals("Madrid", runner.getRunnerClub().getLocation());
    }
}
