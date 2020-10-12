package es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class MuscleGroupEntity {
    @Id
    private String id;
    private String name;
    private List<MuscleUsedEntity> muscleUsedEntityList;

    public MuscleGroupEntity(){
        //empty for the framework
    }

    public MuscleGroupEntity(String id, String name, List<MuscleUsedEntity> muscleUsedEntityList) {
        this.id = id;
        this.name = name;
        this.muscleUsedEntityList = muscleUsedEntityList;
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

    public List<MuscleUsedEntity> getMuscleUsedEntityList() {
        return muscleUsedEntityList;
    }

    public void setMuscleUsedEntityList(List<MuscleUsedEntity> muscleUsedEntityList) {
        this.muscleUsedEntityList = muscleUsedEntityList;
    }

    @Override
    public String toString() {
        return "MuscleGroupEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", muscleUsedEntityList=" + muscleUsedEntityList +
                '}';
    }
}
