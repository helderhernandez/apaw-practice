package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.BeanUtils;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class DiseaseEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    public DiseaseEntity() {
        //empty from framework
    }

    public DiseaseEntity(DiseaseCreation diseaseCreation) {
        BeanUtils.copyProperties(diseaseCreation, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Disease toDisease() {
        Disease disease = new Disease();
        BeanUtils.copyProperties(this, disease);
        return disease;
    }

    @Override
    public boolean equals(Object o) {
        return this == o || o != null && getClass() == o.getClass() && (this.name.equals(((DiseaseEntity) o).getName()));
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
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
