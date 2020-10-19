package es.upm.miw.apaw_practice.domain.models.article;

import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.TypeEntity;

public class Essay {
    private String id;
    private TypeEntity typeEntity;
    private String name;

    public Essay() {
        //empty for framework
    }

    public TypeEntity getTypeEntity() {
        return typeEntity;
    }

    public void setTypeEntity(TypeEntity typeEntity) {
        this.typeEntity = typeEntity;
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

    @Override
    public String toString() {
        return "Essay{" +
                "id='" + id + '\'' +
                ", typeEntity=" + typeEntity +
                ", name='" + name + '\'' +
                '}';
    }
}
