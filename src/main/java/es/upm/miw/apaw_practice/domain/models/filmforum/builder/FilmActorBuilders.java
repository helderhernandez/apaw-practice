package es.upm.miw.apaw_practice.domain.models.filmforum.builder;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;

public class FilmActorBuilders {
    public interface Id {
        Name randomId();

        Name id(String id);
    }

    public interface Name {
        Surname name(String name);
    }

    public interface Surname {
        Age surname(String surname);
    }

    public interface Age {
        Optional age(Integer age);
    }

    public interface Optional {
        FilmActor build();
    }
}
