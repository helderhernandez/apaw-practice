package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class SocialUserCreation {

    private String nickName;
    private String biography;
    private Boolean verified;

    public SocialUserCreation() {
        //empty for framework
    }

    public SocialUserCreation(String nickName, String biography, Boolean verified) {
        this.nickName = nickName;
        this.biography = biography;
        this.verified = verified;
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
        return "SocialUserCreation{" +
                "nickName='" + nickName + '\'' +
                ", biography='" + biography + '\'' +
                ", verified=" + verified +
                '}';
    }

}
