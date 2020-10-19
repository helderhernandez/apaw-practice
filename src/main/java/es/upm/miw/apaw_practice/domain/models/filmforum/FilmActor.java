package es.upm.miw.apaw_practice.domain.models.filmforum;

import es.upm.miw.apaw_practice.domain.models.filmforum.builder.FilmActorBuilder;
import es.upm.miw.apaw_practice.domain.models.filmforum.builder.FilmActorBuilders;

import java.util.UUID;

public class FilmActor {
    private String id;
    private String name;
    private String surname;
    private Integer age;

    private FilmActor() {
    }

    public static FilmActorBuilders.Id builder() {
        return new Builder();
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static class Builder implements FilmActorBuilder {
        private final FilmActor actor;

        public Builder() {
            this.actor = new FilmActor();
        }

        @Override
        public FilmActorBuilders.Name randomId() {
            this.actor.setId(UUID.randomUUID().toString());
            return this;
        }

        @Override
        public FilmActorBuilders.Name id(String id) {
            this.actor.setId(id);
            return this;
        }

        @Override
        public FilmActorBuilders.Surname name(String name) {
            this.actor.setName(name);
            return this;
        }

        @Override
        public FilmActorBuilders.Age surname(String surname) {
            this.actor.setSurname(surname);
            return this;
        }

        @Override
        public FilmActorBuilders.Optional age(Integer age) {
            this.actor.setAge(age);
            return this;
        }

        @Override
        public FilmActor build() {
            return this.actor;
        }
    }

    @Override
    public String toString() {
        return "FilmActor{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
