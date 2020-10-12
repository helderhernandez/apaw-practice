package es.upm.miw.apaw_practice.domain.models.socialnetwork;

public class SocialTrendPositionUpdating {

    private String id;
    private Integer position;

    public SocialTrendPositionUpdating() {
        //empty for framework
    }

    public SocialTrendPositionUpdating(String id, Integer position) {
        this.id = id;
        this.position = position;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "SocialTrendPositionUpdating{" +
                "id='" + id + '\'' +
                ", position=" + position +
                '}';
    }

}
