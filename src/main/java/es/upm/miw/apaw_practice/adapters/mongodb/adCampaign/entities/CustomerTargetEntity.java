package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class CustomerTargetEntity {
    @Id
    private String id;
    private String name;
    private String lastName;
    private String email;
    private Boolean subscribed;
    @DBRef
    private List<LikesEntity> tags;

    public CustomerTargetEntity() {
    }

    public CustomerTargetEntity(String id, String name, String lastName, String email, Boolean subscribed, List<LikesEntity> tags) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.subscribed = subscribed;
        this.tags = tags;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

    public List<LikesEntity> getTags() {
        return tags;
    }

    public void setTags(List<LikesEntity> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "CustomerTargetEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", subscribed='" + subscribed + '\'' +
                ", tags=" + tags +
                '}';
    }
}
