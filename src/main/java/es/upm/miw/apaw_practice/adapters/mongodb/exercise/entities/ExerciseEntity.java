package es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class ExerciseEntity {
    @Id
    private String id;
    private String name;
    private Integer numberOfReps;
    private Integer numberOfSets;
    private List<MuscleGroupEntity> muscleGroupEntityList;
    private List<GymMachineEntity> gymMachineEntityList;
    private LocalDateTime creationDate;

    public ExerciseEntity() {
        //empty for the framework
    }

    public ExerciseEntity(String id, String name, Integer numberOfReps, Integer numberOfSets, List<MuscleGroupEntity> muscleGroupEntityList, List<GymMachineEntity> gymMachineEntityList, LocalDateTime creationDate) {
        this.id = id;
        this.name = name;
        this.numberOfReps = numberOfReps;
        this.numberOfSets = numberOfSets;
        this.muscleGroupEntityList = muscleGroupEntityList;
        this.gymMachineEntityList = gymMachineEntityList;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfReps() {
        return numberOfReps;
    }

    public void setNumberOfReps(Integer numberOfReps) {
        this.numberOfReps = numberOfReps;
    }

    public Integer getNumberOfSets() {
        return numberOfSets;
    }

    public void setNumberOfSets(Integer numberOfSets) {
        this.numberOfSets = numberOfSets;
    }

    public List<MuscleGroupEntity> getMuscleGroupEntityList() {
        return muscleGroupEntityList;
    }

    public void setMuscleGroupEntityList(List<MuscleGroupEntity> muscleGroupEntityList) {
        this.muscleGroupEntityList = muscleGroupEntityList;
    }

    public List<GymMachineEntity> getGymMachineEntityList() {
        return gymMachineEntityList;
    }

    public void setGymMachineEntityList(List<GymMachineEntity> gymMachineEntityList) {
        this.gymMachineEntityList = gymMachineEntityList;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "ExerciseEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberOfReps=" + numberOfReps +
                ", numberOfSets=" + numberOfSets +
                ", muscleGroupEntityList=" + muscleGroupEntityList +
                ", gymMachineEntityList=" + gymMachineEntityList +
                ", creationDate=" + creationDate +
                '}';
    }
}
