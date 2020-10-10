package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.MuscleGroupEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MuscleGroupRepositoryIT {

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    @Test
    void findByName() {
        assertTrue(this.muscleGroupRepository.findByName("Core").isPresent());
        MuscleGroupEntity muscleGroup = this.muscleGroupRepository.findByName("Core").get();
        assertEquals(2, muscleGroup.getMuscleUsedEntityList().size());
    }
}
