package es.upm.miw.apaw_practice.domain.models.sportcentre;

public class Speciality {

    private String id;
    private String title;
    private String description;
    private Integer duration;
    private Boolean recomended;

    public Speciality(){
        //Empty from framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getRecomended() {
        return recomended;
    }

    public void setRecomended(Boolean recomended) {
        this.recomended = recomended;
    }

    @Override
    public String toString() {
        return "Speciality{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", recomended=" + recomended +
                '}';
    }
}
