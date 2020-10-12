package es.upm.miw.apaw_practice.domain.models.videoclub;

import java.time.LocalDate;
import java.util.UUID;

public class FilmMaker {

    private String id;
    private String reference;
    private String name;
    private LocalDate birthday;
    private String gender;

    public FilmMaker() {
        // empty from framework
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public FilmMaker(String reference, String name, LocalDate birthday, String gender) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmMaker filmMaker = (FilmMaker) o;
        return id.equals(filmMaker.id) &&
                reference.equals(filmMaker.reference) &&
                name.equals(filmMaker.name) &&
                birthday.equals(filmMaker.birthday) &&
                gender.equals(filmMaker.gender);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FilmMaker{" +
                "id='" + id + '\'' +
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
