package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestConfig
class RunnerClubPersistenceMongodbIT {

    @Autowired
    RunnerClubPersistenceMongodb runnerClubPersistenceMongodb;

    @Test
    void testCreateAndRead() {
        RunnerClubCreation runnerClubCreation = new RunnerClubCreation("Valencia Runner Club", "Valencia", LocalDateTime.of(2010, 9, 1, 0, 0));
        runnerClubPersistenceMongodb.create(runnerClubCreation);
        RunnerClub runnerClub = runnerClubPersistenceMongodb.findByName("Valencia Runner Club");
        assertEquals("Valencia Runner Club", runnerClub.getName());
        assertEquals("Valencia", runnerClub.getLocation());
        assertEquals(LocalDateTime.of(2010, 9, 1, 0, 0), runnerClub.getFoundationDate());
    }

    @Test
    void testFindByNameNotFound() {
        assertThrows(NotFoundException.class, () -> runnerClubPersistenceMongodb.findByName("No Runner Club"));
    }
}
