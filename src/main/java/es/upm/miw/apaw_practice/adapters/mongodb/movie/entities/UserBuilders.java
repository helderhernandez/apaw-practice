package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

public interface UserBuilders {

    interface Name {
        FulName name(String name);
    }

    interface FulName {
        Age fulName(String fulName);
    }

    interface Age {
        Optionals age(Integer age);
    }

    interface Optionals {
        FilmDirectorEntity build();
    }
}
