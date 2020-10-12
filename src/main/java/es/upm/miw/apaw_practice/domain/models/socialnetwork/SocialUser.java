package es.upm.miw.apaw_practice.domain.models.socialnetwork;

import java.util.List;

public class SocialUser {

    private String id;
    private String nickName;
    private String biography;
    private Boolean verified;
    private List<SocialList> socialLists;
    private List<SocialPost> socialPosts;

    public SocialUser() {
        //empty for framework
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

    public List<SocialList> getSocialLists() {
        return socialLists;
    }

    public void setSocialLists(List<SocialList> socialLists) {
        this.socialLists = socialLists;
    }

    public List<SocialPost> getSocialPosts() {
        return socialPosts;
    }

    public void setSocialPosts(List<SocialPost> socialPosts) {
        this.socialPosts = socialPosts;
    }

    @Override
    public String toString() {
        return "SocialUser{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", biography='" + biography + '\'' +
                ", verified=" + verified +
                ", socialLists=" + socialLists +
                ", socialPosts=" + socialPosts +
                '}';
    }

}
