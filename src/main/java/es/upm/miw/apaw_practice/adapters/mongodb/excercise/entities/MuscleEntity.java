package es.upm.miw.apaw_practice.adapters.mongodb.excercise.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MuscleEntity {
    @Id
    private String id;
    private String name;
    private String bodyPart;

    public MuscleEntity(){
        //empty for the framework
    }

    public MuscleEntity(String id, String name, String bodyPart) {
        this.id = id;
        this.name = name;
        this.bodyPart = bodyPart;
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

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String bodyPart) {
        this.bodyPart = bodyPart;
    }

    @Override
    public String toString() {
        return "MuscleEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bodyPart='" + bodyPart + '\'' +
                '}';
    }
}
