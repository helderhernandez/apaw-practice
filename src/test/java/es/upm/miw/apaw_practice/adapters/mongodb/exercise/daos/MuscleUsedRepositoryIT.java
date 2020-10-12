package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.MuscleUsedEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class MuscleUsedRepositoryIT {

    @Autowired
    private MuscleUsedRepository muscleUsedRepository;

    @Test
    void testFindByName() {
        assertTrue(this.muscleUsedRepository.findByName("Biceps").isPresent());
        MuscleUsedEntity muscle = this.muscleUsedRepository.findByName("Biceps").get();
        assertEquals("Arm", muscle.getBodyPart());
    }

}
