package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RunnerClubEntityRepositoryIT {

    @Autowired
    private RunnerClubRepository runnerClubRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.runnerClubRepository.findById("1").isPresent());
    }
}
