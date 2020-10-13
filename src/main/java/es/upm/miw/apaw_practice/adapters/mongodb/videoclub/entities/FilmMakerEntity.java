package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
public class FilmMakerEntity {
    @Id
    private String id;
    @Indexed(unique = true)
    private String reference;
    private String name;
    private LocalDate birthday;
    private String gender;

    public FilmMakerEntity() {
        // empty from framework
    }

    public FilmMakerEntity(String reference, String name, LocalDate birthday, String gender) {
        this.id = UUID.randomUUID().toString();
        this.reference = reference;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public FilmMakerEntity(FilmMaker filmMaker) {
        BeanUtils.copyProperties(filmMaker, this);
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                reference.equals(filmMakerEntity.reference) &&
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
                ", reference='" + reference + '\'' +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                '}';
    }
}
