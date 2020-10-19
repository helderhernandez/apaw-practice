package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ArtistEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private String county;

    public ArtistEntity() {
    }

    public ArtistEntity(String id, String name, String surname, String county) {
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
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass()
                && (id.equals(((ArtistEntity) obj).id));
    }

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
