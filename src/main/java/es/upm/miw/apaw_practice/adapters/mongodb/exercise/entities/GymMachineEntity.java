package es.upm.miw.apaw_practice.adapters.mongodb.exercise.entities;

import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class GymMachineEntity {
    @Id
    private String id;
    private String name;
    private Boolean useWeighs;

    public GymMachineEntity() {
        //empty for the framework
    }

    public GymMachineEntity(String id, String name, Boolean useWeighs) {
        this.id = id;
        this.name = name;
        this.useWeighs = useWeighs;
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

    public Boolean getUseWeighs() {
        return useWeighs;
    }

    public void setUseWeighs(Boolean useWeighs) {
        this.useWeighs = useWeighs;
    }

    @Override
    public String toString() {
        return "GymMachineEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", useWeighs=" + useWeighs +
                '}';
    }
}
