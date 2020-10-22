package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.time.LocalDate;

@Document
public class CollectionEntity {
    @Id
    private String id;
    private String name;
    private LocalDate initialDate;
    private Integer duration;
    @DBRef
    private List<PaintEntity> paintEntities;

    public CollectionEntity() {
        //empty from framework
    }

    public CollectionEntity(String id, String name, LocalDate initialDate, Integer duration, List<PaintEntity> paintEntities) {
        this.id = id;
        this.name = name;
        this.initialDate = initialDate;
        this.duration = duration;
        this.paintEntities = paintEntities;
    }

    //#region Getters and Setters

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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public List<PaintEntity> getPaintEntities() {
        return paintEntities;
    }

    public void setPaintEntities(List<PaintEntity> paintEntities) {
        this.paintEntities = paintEntities;
    }

    //#endregion

    //#region Override methods

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (id.equals(((CollectionEntity) obj).id));
    }

    @Override
    public String toString() {
        return String.format(
                "PatronEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "initialDate=%s, " +
                        "duration=%d, " +
                        "paintEntities=%s" +
                "}",
                id,
                name,
                initialDate.toString(),
                duration,
                paintEntities
        );
    }

    //#endregion
}
