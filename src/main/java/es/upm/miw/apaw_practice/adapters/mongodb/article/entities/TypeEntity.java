package es.upm.miw.apaw_practice.adapters.mongodb.article.entities;

import es.upm.miw.apaw_practice.domain.models.article.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class TypeEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private String description;

    public TypeEntity() {
        //empty from framework
    }

    public TypeEntity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TypeEntity(Type type) {
        BeanUtils.copyProperties(type, this);
        this.id = UUID.randomUUID().toString();
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


    public Type toType1(){
        Type type = new Type();
        BeanUtils.copyProperties(this, type);
        return type;

    }

    public void fromType(Type type) { BeanUtils.copyProperties(type, this); }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((es.upm.miw.apaw_practice.adapters.mongodb.article.entities.TypeEntity)obj).name));
    }


    @Override
    public String toString() {
        return "TypeEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
