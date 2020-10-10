package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities;

import nonapi.io.github.classgraph.json.Id;

import java.util.UUID;

public class DiseaseEntity {
    @Id
    private String id;
    private String name;
    private String description;

    public DiseaseEntity(String name, String description) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (this.id.equals(((DiseaseEntity) o).getId()));
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "DiseaseEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
