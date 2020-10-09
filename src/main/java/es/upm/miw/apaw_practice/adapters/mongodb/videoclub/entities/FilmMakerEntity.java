package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Document
public class FilmMakerEntity {
    @Id
    private String id;
    private String name;
    private String familyName;
    private LocalDate birthday;
    private String gender;

    public FilmMakerEntity() {
        // empty from framework
    }

    public FilmMakerEntity(String id, String name, String familyName, LocalDate birthday, String gender) {
        this.id = id;
        this.name = name;
        this.familyName = familyName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
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
        FilmMakerEntity filmMakerEntity = (FilmMakerEntity) o;
        return id.equals(filmMakerEntity.id) &&
                name.equals(filmMakerEntity.name) &&
                familyName.equals(filmMakerEntity.familyName) &&
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
                ", familyName='" + familyName + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
