package es.upm.miw.apaw_practice.adapters.mongodb.race.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite.TreeRunners;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite.TreeRunnersComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite.TreeRunnersLeaf;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testRunnerComposite() {
        TreeRunners root = new TreeRunnersComposite("Runner Groups by Runner Club Name");
        TreeRunners composite1 = new TreeRunnersComposite("Runners Club");
        TreeRunners composite2 = new TreeRunnersComposite("BCN Runners Club");
        RunnerEntity runner1 = runnerRepository.findById("1").get();
        RunnerEntity runner2 = runnerRepository.findById("2").get();
        RunnerEntity runner3 = runnerRepository.findById("3").get();
        RunnerEntity runner4 = runnerRepository.findById("4").get();
        TreeRunners leaf1 = new TreeRunnersLeaf(runner1);
        TreeRunners leaf2 = new TreeRunnersLeaf(runner2);
        TreeRunners leaf3 = new TreeRunnersLeaf(runner3);
        TreeRunners leaf4 = new TreeRunnersLeaf(runner4);

        root.add(composite1);
        root.add(composite2);
        composite1.add(leaf1);
        composite1.add(leaf2);
        composite2.add(leaf3);
        composite2.add(leaf4);
        composite2.remove(leaf4);

        assertTrue(composite1.isComposite());
        assertFalse(leaf1.isComposite());
        assertEquals("Runners Club", composite1.runnerClubName());
        assertEquals("Runners Club", leaf1.runnerClubName());
        assertEquals("BCN Runners Club", composite2.runnerClubName());
        assertEquals("BCN Runners Club", leaf3.runnerClubName());
    }
}
