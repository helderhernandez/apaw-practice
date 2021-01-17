package es.upm.miw.apaw_practice.domain.models.museum;

public interface ArtistsBuilder {

    interface Id{
        Name id(String id);
    }
    interface Name {
        Surname name(String name);
    }
    interface Surname {
        Country surname(String surname);
    }
    interface Country {
        Artist build(String country);
    }
}
