package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.Runner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testReadByIdNotFound() {
        assertThrows(NotFoundException.class, () -> runnerPersistenceMongodb.readById("-1"));
    }

    @Test
    void testReadByDni() {
        Runner runner = runnerPersistenceMongodb.readByDni("00000002");
        assertEquals("Maria", runner.getName());
        assertTrue(runner.getProfessional());
        assertEquals("Madrid", runner.getRunnerClub().getLocation());
    }

    @Test
    void testReadByDniNotFound() {
        assertThrows(NotFoundException.class, () -> runnerPersistenceMongodb.readByDni("-1"));
    }

    @Test
    void testUpdateAndRead() {
        Runner runner = runnerPersistenceMongodb.readById("3");
        assertEquals("Jose", runner.getName());
        runner.setName("Manuel");
        runnerPersistenceMongodb.update(runner);
        Runner runner2 = runnerPersistenceMongodb.readById("3");
        assertEquals("Manuel", runner2.getName());
    }

    @Test
    void testUpdateException() {
        Runner runner = runnerPersistenceMongodb.readById("3");
        runner.setId("-1");
        assertThrows(NotFoundException.class, () -> runnerPersistenceMongodb.update(runner));
    }
}
