package es.upm.miw.apaw_practice.domain.models.museum;

import java.time.LocalDate;
import java.util.List;

public class Paint {

    private String id;
    private String name;
    private LocalDate creation;
    private String technique;
    private Boolean isRestoring;
    private Artist artist;
    private List<ArtRestorer> artRestorers;

    public Paint() {
        //empty from framework
    }

    public Paint(String name, LocalDate creation, String technique, Boolean isRestoring, Artist artist, List<ArtRestorer> artRestorers) {
        this.name = name;
        this.creation = creation;
        this.technique = technique;
        this.isRestoring = isRestoring;
        this.artist = artist;
        this.artRestorers = artRestorers;
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

    public Artist getArtistEntity() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<ArtRestorer> getArtRestorers() {
        return artRestorers;
    }

    public void setArtRestorer(List<ArtRestorer> artRestorers) {
        this.artRestorers = artRestorers;
    }

    //#endregion

    //#region Override methods

    @Override
    public String toString() {
        return String.format(
                "Paint{" +
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
                artist,
                artRestorers
        );
    }

    //#endregion
}
