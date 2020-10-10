package es.upm.miw.apaw_practice.adapters.mongodb.excersise;

import es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos.ExerciseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos.GymMachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos.MuscleGroupRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.daos.MuscleUsedRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.ExerciseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.GymMachineEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.MuscleGroupEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities.MuscleUsedEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseSeedService {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private GymMachineRepository gymMachineRepository;
    @Autowired
    private MuscleGroupRepository muscleGroupRepository;
    @Autowired
    private MuscleUsedRepository muscleUsedRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Exercise Initial Load -----------");
        MuscleUsedEntity[] muscle = {
                new MuscleUsedEntity("1", "Pectoralis Major", "Chess"),
                new MuscleUsedEntity("2", "Deltoid", "Chess"),
                new MuscleUsedEntity("3", "Triceps", "Arm"),
                new MuscleUsedEntity("4", "Biceps", "Arm"),
                new MuscleUsedEntity("5", "Gluteus Maximus", "Leg"),
                new MuscleUsedEntity("6", "Hamstring", "Leg"),
                new MuscleUsedEntity("7", "Adductor Longus", "Leg"),
                new MuscleUsedEntity("8", "Quadriceps", "Leg"),
                new MuscleUsedEntity("9", "Oblique", "Torso"),
                new MuscleUsedEntity("10", "Abdominal", "Torso")

        };
        this.muscleUsedRepository.saveAll(Arrays.asList(muscle));
        MuscleGroupEntity[] muscleGroup = {
                new MuscleGroupEntity("1", "Upper Body", List.of((muscle[0]), muscle[1], muscle[2], muscle[3])),
                new MuscleGroupEntity("2", "Lower Body", List.of((muscle[4]), muscle[5], muscle[6], muscle[7])),
                new MuscleGroupEntity("3", "Core", List.of((muscle[8]), muscle[9]))
        };
        this.muscleGroupRepository.saveAll(Arrays.asList(muscleGroup));
        GymMachineEntity[] machine = {
                new GymMachineEntity("1", "Olympic flat bench ", true),
                new GymMachineEntity("2", "AB bench pro", false),
                new GymMachineEntity("3", "Smith machine", true),
                new GymMachineEntity("4", "Cable crossover", true),
                new GymMachineEntity("5", "Preacher bench", true),
                new GymMachineEntity("6", "Flat bench", true)

        };
        this.gymMachineRepository.saveAll(Arrays.asList(machine));

        ExerciseEntity[] exercise = {
                new ExerciseEntity("1", "Bench press", 12, 3, List.of(muscleGroup[0]),
                        List.of(machine[1], machine[5]), LocalDateTime.now()),
                new ExerciseEntity("2", "Squads", 10, 3, List.of(muscleGroup[1], muscleGroup[2]),
                        List.of(machine[2]), LocalDateTime.now()),
                new ExerciseEntity("3", "Crossover Fly", 10, 3, List.of(muscleGroup[0]),
                        List.of(machine[3]), LocalDateTime.now())

        };
        this.exerciseRepository.saveAll(Arrays.asList(exercise));
    }

    public void deleteAll(){
        this.muscleUsedRepository.deleteAll();
        this.muscleGroupRepository.deleteAll();
        this.gymMachineRepository.deleteAll();
        this.exerciseRepository.deleteAll();
    }
}
