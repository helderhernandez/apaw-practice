package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerClubEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class RunnerClubEntityRepositoryIT {

    @Autowired
    private RunnerClubRepository runnerClubRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.runnerClubRepository.findById("1").isPresent());
        RunnerClubEntity runnerClub = this.runnerClubRepository.findById("1").get();
        assertEquals("Runners Club", runnerClub.getName());
    }

    @Test
    void testBuilder() {
        RunnerClubEntity runnerClubEntity =
                RunnerClubEntity.builder()
                        .id("id")
                        .name("Built Runner Club")
                        .location("Gijón")
                        .foundationDate(LocalDateTime.of(2019, 5, 1, 0, 0))
                        .build();

        assertNotNull(runnerClubEntity);
        assertEquals("id", runnerClubEntity.getId());
        assertEquals("Built Runner Club", runnerClubEntity.getName());
        assertEquals("Gijón", runnerClubEntity.getLocation());
        assertEquals(LocalDateTime.of(2019, 5, 1, 0, 0), runnerClubEntity.getFoundationDate());
    }
}
