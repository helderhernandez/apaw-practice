package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document
public class SpecialityEntity {

    @Id
    private String id;
    private String title;
    private String description;
    private int duration;
    private boolean recomended;


    public SpecialityEntity(String id, String title, String description, int duration, boolean recomended) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.recomended = recomended;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean isRecomended() {
        return recomended;
    }

    public void setRecomended(boolean recomended) {
        this.recomended = recomended;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialityEntity that = (SpecialityEntity) o;
        return duration == that.duration &&
                recomended == that.recomended &&
                id.equals(that.id) &&
                title.equals(that.title) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, duration, recomended);
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
