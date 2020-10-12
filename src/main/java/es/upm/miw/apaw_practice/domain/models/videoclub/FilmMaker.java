package es.upm.miw.apaw_practice.domain.models.videoclub;

import java.time.LocalDate;
import java.time.Period;

public class FilmMaker {

    private String id;
    private String name;
    private LocalDate birthday;
    private String gender;

    public FilmMaker() {
        // empty from framework
    }

    public FilmMaker(String id, String name, LocalDate birthday, String gender) {
        this.id = id;
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

    public Integer getAge() {
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday, today);
        return p.getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmMaker filmMaker = (FilmMaker) o;
        return id.equals(filmMaker.id) &&
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
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
