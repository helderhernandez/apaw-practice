package es.upm.miw.apaw_practice.adapters.mongodb.exercise.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities.ExerciseEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ExerciseEntityRepositoryIT {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Test
    void testFindByName() {
        assertTrue(this.exerciseRepository.findByName("Squads").isPresent());
        ExerciseEntity exercise = this.exerciseRepository.findByName("Squads").get();
        assertEquals("2", exercise.getId());
        assertEquals(10, exercise.getNumberOfReps());
        assertEquals(3, exercise.getNumberOfSets());
        assertEquals(2, exercise.getMuscleGroupEntityList().size());
        assertEquals(1, exercise.getGymMachineEntityList().size());
        assertTrue(exercise.getCreationDate().isBefore(LocalDateTime.now()));
    }
}
