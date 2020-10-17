package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.FilmCategoryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmCategoryEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmCategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("filmCategoryPersistence")
public class FilmCategoryPersistenceMongodb implements FilmCategoryPersistence {

    private FilmCategoryRepository filmCategoryRepository;

    @Autowired
    public FilmCategoryPersistenceMongodb(FilmCategoryRepository filmCategoryRepository) {
        this.filmCategoryRepository = filmCategoryRepository;
    }

    @Override
    public FilmCategory readByReference(String reference) {
        return this.filmCategoryRepository
                .findByReference(reference)
                .orElseThrow(() -> new NotFoundException("Reference: " + reference))
                .toFilmCategory();
    }

    @Override
    public FilmCategory update(FilmCategory filmCategory) {
        FilmCategoryEntity filmCategoryEntity = this.filmCategoryRepository
                .findByReference(filmCategory.getReference())
                .orElseThrow(() -> new NotFoundException("FilmCategory reference: " + filmCategory.getReference()));
        filmCategoryEntity.fromFilmCategory(filmCategory);

        return this.filmCategoryRepository
                .save(filmCategoryEntity)
                .toFilmCategory();
    }
}
