package es.upm.miw.apaw_practice.domain.models.filmforum;

public class FilmActorAgeUpdating {
    private String name;
    private String surname;
    private Integer age;

    public FilmActorAgeUpdating() {
        // Empty for Framework
    }

    public FilmActorAgeUpdating(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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
}