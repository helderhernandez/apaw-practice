package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

import es.upm.miw.apaw_practice.domain.models.movie.FilmDirector;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class FilmDirectorEntity {
    @Id
    private String id;
    private String name;
    private String fullName;
    private Integer age;

    public FilmDirectorEntity() {
        //empty from framework
    }

    public static UserBuilders.Name builder() {
        return new Builder();
    }

    public static class Builder implements UserBuilders.Name, UserBuilders.FulName, UserBuilders.Age, UserBuilders.Optionals {

        private FilmDirectorEntity filmDirectorEntity;

        public Builder() {
            this.filmDirectorEntity = new FilmDirectorEntity();
        }

        @Override
        public UserBuilders.FulName name(String name) {
            this.filmDirectorEntity.name = name;
            return this;
        }

        @Override
        public UserBuilders.Age fulName(String fulName) {
            this.filmDirectorEntity.fullName = fulName;
            return this;
        }

        @Override
        public UserBuilders.Optionals age(Integer age) {
            this.filmDirectorEntity.age = age;
            return this;
        }

        @Override
        public FilmDirectorEntity build() {
            return this.filmDirectorEntity;
        }
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public FilmDirector toFilmDirector() {
        FilmDirector filmDirector = new FilmDirector();
        BeanUtils.copyProperties(this, filmDirector);
        return filmDirector;
    }

    @Override
    public String toString() {
        return "FilmDirectorEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                '}';
    }
}
