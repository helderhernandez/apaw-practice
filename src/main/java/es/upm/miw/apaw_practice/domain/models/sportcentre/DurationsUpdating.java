package es.upm.miw.apaw_practice.domain.models.sportcentre;

public class DurationsUpdating {

    private String id;
    private Integer duration;

    public DurationsUpdating(){
        //Empty from framework
    }

    public DurationsUpdating(String id, Integer duration) {
        this.id = id;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "DurationsUpdating{" +
                "id='" + id + '\'' +
                ", duration=" + duration +
                '}';
    }
}
