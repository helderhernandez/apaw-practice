package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.adapters.rest.museum.ArtRestorerJobTitleDto;
import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface ArtRestorerPersistence {

    ArtRestorer readById(String id);
    ArtRestorer update(ArtRestorer artRestorer);
    Stream<ArtRestorerJobTitleDto> findArtRestorerJobTitlesByArtistCountry(String artistCountry);
}
