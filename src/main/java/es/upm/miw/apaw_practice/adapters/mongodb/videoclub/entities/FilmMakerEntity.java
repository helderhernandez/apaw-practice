package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;

@Document
public class FilmMakerEntity {
    @Id
    private String id;
    private String name;
    private LocalDate birthday;
    private String gender;

    public FilmMakerEntity() {
        // empty from framework
    }

    public FilmMakerEntity(String id, String name, LocalDate birthday, String gender) {
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

    public FilmMaker toFilmMaker() {
        FilmMaker filmMaker = new FilmMaker();
        BeanUtils.copyProperties(this, filmMaker);
        return filmMaker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmMakerEntity filmMakerEntity = (FilmMakerEntity) o;
        return id.equals(filmMakerEntity.id) &&
                name.equals(filmMakerEntity.name) &&
                birthday.equals(filmMakerEntity.birthday) &&
                gender.equals(filmMakerEntity.gender);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return "FilmMakerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
