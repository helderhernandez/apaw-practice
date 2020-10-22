package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;
import java.time.LocalDate;


public class PaintEntity {

    @Id
    private String id;
    private String name;
    private LocalDate creation;
    private String technique;
    private Boolean isRestoring;
    @DBRef
    private ArtistEntity artistEntity;
    @DBRef
    private List<ArtRestorerEntity> artRestorerEntities;

    public PaintEntity() {
        //empty from framework
    }

    public PaintEntity(String id,
                       String name,
                       LocalDate creation,
                       String technique,
                       Boolean isRestoring,
                       ArtistEntity artistEntity,
                       List<ArtRestorerEntity> artRestorerEntities) {
        this.id = id;
        this.name = name;
        this.creation = creation;
        this.technique = technique;
        this.isRestoring = isRestoring;
        this.artistEntity = artistEntity;
        this.artRestorerEntities = artRestorerEntities;
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

    public LocalDate getCreation() {
        return creation;
    }

    public void setCreation(LocalDate creation) {
        this.creation = creation;
    }

    public String getTechnique() {
        return technique;
    }

    public void setTechnique(String technique) {
        this.technique = technique;
    }

    public Boolean getRestoring() {
        return isRestoring;
    }

    public void setRestoring(Boolean restoring) {
        isRestoring = restoring;
    }

    public ArtistEntity getArtistEntity() {
        return artistEntity;
    }

    public void setArtistEntity(ArtistEntity artistEntity) {
        this.artistEntity = artistEntity;
    }

    public List<ArtRestorerEntity> getArtRestorerEntities() {
        return artRestorerEntities;
    }

    public void setArtRestorerEntities(List<ArtRestorerEntity> artRestorerEntities) {
        this.artRestorerEntities = artRestorerEntities;
    }

    //#endregion

    //#region Override methods

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (id.equals(((PaintEntity) obj).id));
    }

    @Override
    public String toString() {
        return String.format(
                "PaintEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "creation=%s, " +
                        "technique=%s, " +
                        "isRestoring=%s" +
                        "artistEntity=%s" +
                        "arRestorerEntities=%s" +
                        "}",
                id,
                name,
                creation.toString(),
                technique,
                isRestoring.toString(),
                artistEntity,
                artRestorerEntities
        );
    }

    //#endregion
}
