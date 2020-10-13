package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.FilmMakerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmMakerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmMakerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("filmMakerPersistence")
public class FilmMakerPersistenceMongodb implements FilmMakerPersistence {

    private FilmMakerRepository filmMakerRepository;

    @Autowired
    public FilmMakerPersistenceMongodb(FilmMakerRepository filmMakerRepository) {
        this.filmMakerRepository = filmMakerRepository;
    }

    @Override
    public FilmMaker create(FilmMaker filmMaker) {
        return this.filmMakerRepository
                .save(new FilmMakerEntity(filmMaker))
                .toFilmMaker();
    }

    @Override
    public FilmMaker readByReference(String reference) {
        return this.filmMakerRepository
                .findByReference(reference)
                .orElseThrow(() -> new NotFoundException("Reference: " + reference))
                .toFilmMaker();
    }
}
