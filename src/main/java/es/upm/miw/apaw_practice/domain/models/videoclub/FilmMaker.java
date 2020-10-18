package es.upm.miw.apaw_practice.domain.models.videoclub;

import java.time.LocalDate;
import java.util.UUID;

public class FilmMaker {

    private String reference;
    private String name;
    private LocalDate birthday;
    private String gender;

    public FilmMaker() {
        // empty from framework
    }

    public FilmMaker(String reference, String name, LocalDate birthday, String gender) {
        this.reference = reference;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "FilmMaker{" +
                "reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
