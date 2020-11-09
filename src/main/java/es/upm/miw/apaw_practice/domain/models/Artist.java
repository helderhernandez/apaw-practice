package es.upm.miw.apaw_practice.domain.models;


public class Artist {
    private String id;
    private String name;
    private String surname;
    private String county;

    public Artist() { }

    public Artist(String id, String name, String surname, String county) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.county = county;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    //#endregion

    //#region Override methods

    @Override
    public String toString() {
        return String.format(
                "ArtistEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "surname=%s, " +
                        "country=%s, " +
                        "}",
                id,
                name,
                surname,
                county
        );
    }

    //#endregion
}
