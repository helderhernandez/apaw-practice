package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RunnerEntityRepositoryIT {

    @Autowired
    private RunnerRepository runnerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(runnerRepository.findById("3").isPresent());
        RunnerEntity runner = runnerRepository.findById("3").get();
        assertEquals("00000003", runner.getDni());
    }
}
