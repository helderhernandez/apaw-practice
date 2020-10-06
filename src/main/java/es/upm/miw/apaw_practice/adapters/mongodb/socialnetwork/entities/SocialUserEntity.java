package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class SocialUserEntity {

    @Id
    private String id;
    @Indexed(unique = true)
    private String nickName;
    private String biography;
    private Boolean verified;
    @DBRef
    private List<SocialPostEntity> socialPostEntities;
    @DBRef
    private List<SocialListEntity> socialListEntities;

    public SocialUserEntity() {
        //empty from framework
    }

    public SocialUserEntity(String nickName, String biography, Boolean verified, List<SocialPostEntity> socialPostEntities, List<SocialListEntity> socialListEntities) {
        this.id = UUID.randomUUID().toString();
        this.nickName = nickName;
        this.biography = biography;
        this.verified = verified;
        this.socialPostEntities = socialPostEntities;
        this.socialListEntities = socialListEntities;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Boolean isVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public List<SocialPostEntity> getSocialPostEntities() {
        return socialPostEntities;
    }

    public void setSocialPostEntities(List<SocialPostEntity> socialPostEntities) {
        this.socialPostEntities = socialPostEntities;
    }

    public List<SocialListEntity> getSocialListEntities() {
        return socialListEntities;
    }

    public void setSocialListEntities(List<SocialListEntity> socialListEntities) {
        this.socialListEntities = socialListEntities;
    }

    @Override
    public int hashCode() {
        return this.nickName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (nickName.equals(((SocialUserEntity) obj).nickName));
    }

    @Override
    public String toString() {
        return "SocialUserEntity{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", biography='" + biography + '\'' +
                ", verified='" + verified + '\'' +
                '}';
    }

}
