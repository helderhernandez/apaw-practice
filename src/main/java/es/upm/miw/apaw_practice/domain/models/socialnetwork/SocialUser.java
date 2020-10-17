package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.util.List;

public class SocialUser {

    private String id;
    private String nickName;
    private String biography;
    private Boolean verified;
    private List<String> socialListIds;
    private List<String> socialPostIds;

    public SocialUser() {
        //empty for framework
    }

    public SocialUser(String id, String nickName, String biography, Boolean verified, List<String> socialListIds, List<String> socialPostIds) {
        this.id = id;
        this.nickName = nickName;
        this.biography = biography;
        this.verified = verified;
        this.socialListIds = socialListIds;
        this.socialPostIds = socialPostIds;
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

    public List<String> getSocialListIds() {
        return socialListIds;
    }

    public void setSocialListIds(List<String> socialListIds) {
        this.socialListIds = socialListIds;
    }

    public List<String> getSocialPostIds() {
        return socialPostIds;
    }

    public void setSocialPostIds(List<String> socialPostIds) {
        this.socialPostIds = socialPostIds;
    }

    @Override
    public String toString() {
        return "SocialUser{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", biography='" + biography + '\'' +
                ", verified=" + verified +
                ", socialListIds=" + socialListIds +
                ", socialPostIds=" + socialPostIds +
                '}';
    }

}
