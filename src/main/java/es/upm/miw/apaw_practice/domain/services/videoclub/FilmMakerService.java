package es.upm.miw.apaw_practice.domain.services.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmMakerPersistence;
import org.springframework.stereotype.Service;

@Service
public class FilmMakerService {

    private FilmMakerPersistence filmMakerPersistence;

    public FilmMakerService(FilmMakerPersistence filmMakerPersistence) {
        this.filmMakerPersistence = filmMakerPersistence;
    }

    public FilmMaker create(FilmMaker filmMaker) {
        return this.filmMakerPersistence.create(filmMaker);
    }
}
