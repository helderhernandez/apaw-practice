package es.upm.miw.apaw_practice.domain.models.videoclub;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class CustomerAssociate {

    private String documentId;
    private String name;
    private LocalDate birthday;
    private LocalDateTime registrationDate;
    private List<RentalFilm> films;

    public CustomerAssociate() {
        // empty from framework
    }

    public CustomerAssociate(String documentId, String name, LocalDate birthday, List<RentalFilm> films) {
        this.documentId = documentId;
        this.name = name;
        this.birthday = birthday;
        this.registrationDate = LocalDateTime.now();
        this.films = films;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public List<RentalFilm> getFilms() {
        return films;
    }

    public void setFilms(List<RentalFilm> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "CustomerAssociate{" +
                "documentId='" + documentId + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", films=" + films +
                '}';
    }
}
