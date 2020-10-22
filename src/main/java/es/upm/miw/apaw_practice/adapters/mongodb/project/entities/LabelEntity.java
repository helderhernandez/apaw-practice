package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

import es.upm.miw.apaw_practice.domain.models.project.Label;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;

@Document
public class LabelEntity {

    @Id
    private String id;
    private String name;
    private String description;

    public LabelEntity() {
        //empty for framework
    }

    public LabelEntity(Label label) {
        BeanUtils.copyProperties(label, this);
        this.id = UUID.randomUUID().toString();
    }

    public static Builder builder() {
        return new Builder();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Label toLabel() {
        Label label = new Label();
        BeanUtils.copyProperties(this, label);
        return label;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((LabelEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "LabelEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private LabelEntity labelEntity;

        public Builder() {
            this.labelEntity = new LabelEntity();
            this.labelEntity.setId(UUID.randomUUID().toString());
        }

        public Builder name(String name) {
            this.labelEntity.setName(name);
            return this;
        }

        public Builder description(String description) {
            this.labelEntity.setDescription(description);
            return this;
        }

        public LabelEntity build() {
            return this.labelEntity;
        }

    }

}
