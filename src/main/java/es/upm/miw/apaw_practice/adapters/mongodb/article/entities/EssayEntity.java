package es.upm.miw.apaw_practice.adapters.mongodb.article.entities;

import es.upm.miw.apaw_practice.domain.models.article.Essay;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class EssayEntity {
    @DBRef
    private TypeEntity typeEntity;
    @Id
    private String id;
    private String name;

    public EssayEntity() {
        //empty from framework
    }

    public EssayEntity(TypeEntity typeEntity, String id, String name) {
        this.typeEntity = typeEntity;
        this.id = id;
        this.name = name;
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

    public Essay toEssay(){
        Essay essay = new Essay();
        BeanUtils.copyProperties(this, essay);
        return essay;
    }

    @Override
    public String toString() {
        return "EssayEntity{" +
                "typeEntity=" + typeEntity +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
