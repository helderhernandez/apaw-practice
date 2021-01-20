package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtRestorerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ArtRestorerService {

    private ArtRestorerPersistence artRestorerPersistence;

    @Autowired
    public ArtRestorerService(ArtRestorerPersistence artRestorerPersistence) {
        this.artRestorerPersistence = artRestorerPersistence;
    }

    public ArtRestorer update(String id, ArtRestorer artRestorer) {
        ArtRestorer artRestorer1 = this.artRestorerPersistence.readById(id);
        artRestorer.setName(artRestorer.getName());
        artRestorer.setSurname(artRestorer.getSurname());
        artRestorer.setJobTitle(artRestorer.getJobTitle());
        return this.artRestorerPersistence.update(artRestorer);
    }

    public Stream<String> findArtRestorerJobTitlesByArtistCountry(String artistCountry) {
        return this.artRestorerPersistence.findArtRestorerJobTitlesByArtistCountry(artistCountry);
    }
}
