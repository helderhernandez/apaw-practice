package es.upm.miw.apaw_practice.domain.services.museum;

import es.upm.miw.apaw_practice.domain.models.museum.ArtRestorer;
import es.upm.miw.apaw_practice.domain.persistence_ports.museum.ArtRestorerPersistence;
import org.springframework.stereotype.Service;

@Service
public class ArtRestorerService {

    private ArtRestorerPersistence artRestorerPersistence;

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
}
