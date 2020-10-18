package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.FilmCategoryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmCategoryEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmCategoryPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Override
    public Stream<String> findDistinctPlus18ByRentalFilms(Stream<RentalFilm> rentalFilms) {
        List<String> filmCategories = rentalFilms.flatMap(rentalFilm -> rentalFilm.getCategories().stream())
                .map(FilmCategory::getReference)
                .collect(Collectors.toList());
        return this.filmCategoryRepository.findAll().stream()
                .map(FilmCategoryEntity::toFilmCategory)
                .filter(FilmCategory::getPlus18)
                .filter(filmCategory -> filmCategories.contains(filmCategory.getReference()))
                .map(FilmCategory::getName)
                .distinct();
    }
}
