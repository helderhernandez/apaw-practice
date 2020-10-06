package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class SocialTrendEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private Integer position;
    @DBRef
    private SocialPostEntity socialPostEntity;

    public SocialTrendEntity() {
        //empty from framework
    }

    public SocialTrendEntity(String name, Integer position, SocialPostEntity socialPostEntity) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.position = position;
        this.socialPostEntity = socialPostEntity;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public SocialPostEntity getSocialPostEntity() {
        return socialPostEntity;
    }

    public void setSocialPostEntity(SocialPostEntity socialPostEntity) {
        this.socialPostEntity = socialPostEntity;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((SocialTrendEntity) obj).id));
    }

    @Override
    public String toString() {
        return "SocialTrendEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
