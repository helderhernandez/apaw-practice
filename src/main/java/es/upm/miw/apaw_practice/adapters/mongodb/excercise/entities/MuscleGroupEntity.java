package es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class MuscleGroupEntity {
    @Id
    private String id;
    private String name;
    private List<MuscleEntity> muscleEntityList;

    public MuscleGroupEntity(){
        //empty for the framework
    }

    public MuscleGroupEntity(String id, String name, List<MuscleEntity> muscleEntityList) {
        this.id = id;
        this.name = name;
        this.muscleEntityList = muscleEntityList;
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

    public List<MuscleEntity> getMuscleEntityList() {
        return muscleEntityList;
    }

    public void setMuscleEntityList(List<MuscleEntity> muscleEntityList) {
        this.muscleEntityList = muscleEntityList;
    }

    @Override
    public String toString() {
        return "MuscleGroupEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", muscleEntityList=" + muscleEntityList +
                '}';
    }
}
