package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class SocialUser {

    private String id;
    private String nickName;
    private String biography;
    private Boolean verified;

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

    @Override
    public String toString() {
        return "SocialUser{" +
                "id='" + id + '\'' +
                ", nickName='" + nickName + '\'' +
                ", biography='" + biography + '\'' +
                ", verified=" + verified +
                '}';
    }

}
