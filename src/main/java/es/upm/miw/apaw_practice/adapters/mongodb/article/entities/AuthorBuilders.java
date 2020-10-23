package es.upm.miw.apaw_practice.adapters.mongodb.article.entities;

public interface AuthorBuilders {

    interface Name {
        Surname name(String name);
    }

    interface Surname {
        Nationality surname(String surname);
    }

    interface Nationality {
        Optionals nationality(String nationality);
    }

    interface Optionals {
        AuthorEntity build();
    }

}
