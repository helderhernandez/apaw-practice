package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class SocialTrend {

    private String id;
    private String name;
    private Integer position;
    private SocialPost socialPost;

    public SocialTrend() {
        //empty for framework
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

    public SocialPost getSocialPost() {
        return socialPost;
    }

    public void setSocialPost(SocialPost socialPost) {
        this.socialPost = socialPost;
    }

    @Override
    public String toString() {
        return "SocialTrend{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", socialPost=" + socialPost +
                '}';
    }

}
