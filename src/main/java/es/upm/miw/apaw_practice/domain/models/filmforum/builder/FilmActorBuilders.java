package es.upm.miw.apaw_practice.domain.models.filmforum.builder;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;

public interface FilmActorBuilders {
    interface Id {
        Name randomId();

        Name id(String id);
    }

    interface Name {
        Surname name(String name);
    }

    interface Surname {
        Age surname(String surname);
    }

    interface Age {
        Optional age(Integer age);
    }

    interface Optional {
        FilmActor build();
    }
}
