package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;
import java.util.UUID;


public class ChallengeEntity {

    @Id
    private String id;
    private String description;
    private Boolean isCompleted;

    public ChallengeEntity() {
        //empty for framework
    }

    public ChallengeEntity(String description, Boolean isCompleted) {
        this.id = UUID.randomUUID().toString();
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Boolean getCompleted() { return isCompleted; }

    public void setCompleted(Boolean completed) { isCompleted = completed; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChallengeEntity that = (ChallengeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(description, that.description) &&
                Objects.equals(isCompleted, that.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isCompleted);
    }

    @Override
    public String toString() {
        return "ChallengeEntity{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
