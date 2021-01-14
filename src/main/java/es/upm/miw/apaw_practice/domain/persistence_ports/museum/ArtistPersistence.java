package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Artist;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ArtistPersistence {

    Stream<Artist> readAll();
    Artist readById(String id);
    Artist update(Artist artist);
}
