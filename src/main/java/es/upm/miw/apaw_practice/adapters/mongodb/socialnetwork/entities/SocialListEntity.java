package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialList;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Document
public class SocialListEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Boolean personal;
    @DBRef
    private List<SocialUserEntity> socialUserEntities;

    public SocialListEntity() {
        //empty from framework
    }

    public SocialListEntity(String name, String description, Boolean personal) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.personal = personal;
        this.socialUserEntities = new ArrayList<>();
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

    public Boolean isPersonal() {
        return personal;
    }

    public void setPersonal(Boolean personal) {
        this.personal = personal;
    }

    public List<SocialUserEntity> getSocialUserEntities() {
        return socialUserEntities;
    }

    public void setSocialUserEntities(List<SocialUserEntity> socialUserEntities) {
        this.socialUserEntities = socialUserEntities;
    }

    public SocialList toSocialList() {
        List<String> nickNames = this.socialUserEntities.stream()
                .map(SocialUserEntity::getNickName)
                .collect(Collectors.toList());
        return new SocialList(id, name, description, personal, nickNames);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((SocialListEntity) obj).id));
    }

    @Override
    public String toString() {
        return "SocialListEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", personal='" + personal + '\'' +
                '}';
    }

}
