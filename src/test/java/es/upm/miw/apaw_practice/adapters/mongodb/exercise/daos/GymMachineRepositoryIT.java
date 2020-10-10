package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.GymMachineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class GymMachineRepositoryIT {

    @Autowired
    private GymMachineRepository gymMachineRepository;

    @Test
    void testFindByName() {
        assertTrue(this.gymMachineRepository.findByName("Smith machine").isPresent());
        GymMachineEntity gymMachine = this.gymMachineRepository.findByName("Smith machine").get();
        assertTrue(gymMachine.getUseWeighs());

    }
}
