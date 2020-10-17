package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class SocialTrend {

    private String id;
    private String name;
    private Integer position;
    private String socialPostId;

    public SocialTrend() {
        //empty for framework
    }

    public SocialTrend(String id, String name, Integer position, String socialPostId) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.socialPostId = socialPostId;
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

    public String getSocialPostId() {
        return socialPostId;
    }

    public void setSocialPostId(String socialPostId) {
        this.socialPostId = socialPostId;
    }

    @Override
    public String toString() {
        return "SocialTrend{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", socialPostId=" + socialPostId +
                '}';
    }

}
