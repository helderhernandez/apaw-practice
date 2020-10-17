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
    void testCreateAndReadById() {
        assertTrue(runnerRepository.findById("1").isPresent());
        RunnerEntity runner = runnerRepository.findById("1").get();
        assertEquals("00000001", runner.getDni());
        assertEquals("Juan", runner.getName());
    }

    @Test
    void testCreateAndReadByDni() {
        assertTrue(runnerRepository.findByDni("00000001").isPresent());
        RunnerEntity runner = runnerRepository.findByDni("00000001").get();
        assertEquals("1", runner.getId());
        assertEquals("Juan", runner.getName());
    }
}
