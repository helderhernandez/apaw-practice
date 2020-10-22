package es.upm.miw.apaw_practice.adapters.mongodb.museum.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ArtRestorerEntity {
    @Id
    private String id;
    private String name;
    private String surname;
    private String jobTitle;

    public ArtRestorerEntity() {}

    public ArtRestorerEntity(String id, String name, String surname, String jobTitle) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.jobTitle = jobTitle;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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
                && (id.equals(((ArtRestorerEntity) obj).id));
    }

    @Override
    public String toString() {
        return String.format(
                "ArtRestorerEntity{" +
                        "id=%s, " +
                        "name=%s, " +
                        "surname=%s, " +
                        "jobTitle=%s, " +
                        "}",
                id,
                name,
                surname,
                jobTitle
        );
    }
    //#endregion
}
