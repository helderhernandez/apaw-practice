package es.upm.miw.apaw_practice.domain.models.videogame;

public class ChallengeDescriptionUpdating {

    private String id;
    private String description;
    private Boolean isCompleted;


    public ChallengeDescriptionUpdating(){
        //empty for framework
    }
    public ChallengeDescriptionUpdating(String id, String description, Boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return isCompleted;
    }

    public void setCompleted(Boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "ChallengeDescriptionUpdating{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
