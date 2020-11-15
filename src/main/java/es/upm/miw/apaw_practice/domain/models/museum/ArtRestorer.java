package es.upm.miw.apaw_practice.domain.models.museum;

public class ArtRestorer {

    private String id;
    private String name;
    private String surname;
    private String jobTitle;

    public ArtRestorer() {}

    public ArtRestorer(String id, String name, String surname, String jobTitle) {
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
    public String toString() {
        return String.format(
                "ArtRestorer{" +
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
