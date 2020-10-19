package es.upm.miw.apaw_practice.domain.services.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategoryAdultUpdating;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmCategoryPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.RentalFilmPersistence;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class FilmCategoryService {

    private FilmCategoryPersistence filmCategoryPersistence;
    private RentalFilmPersistence rentalFilmPersistence;

    public FilmCategoryService(FilmCategoryPersistence filmCategoryPersistence, RentalFilmPersistence rentalFilmPersistence) {
        this.filmCategoryPersistence = filmCategoryPersistence;
        this.rentalFilmPersistence = rentalFilmPersistence;
    }

    public void updatePlus18(List<FilmCategoryAdultUpdating> filmCategoryAdultUpdatings) {
        filmCategoryAdultUpdatings.stream()
                .map(newPlus18Update -> {
                    FilmCategory filmCategory = this.filmCategoryPersistence.readByReference(newPlus18Update.getReference());
                    filmCategory.setPlus18(newPlus18Update.getPlus18());
                    return filmCategory;
                }).forEach(filmCategory -> this.filmCategoryPersistence.update(filmCategory));
    }

    public FilmCategory read(String reference) {
        return this.filmCategoryPersistence.readByReference(reference);
    }

    public Stream<String> findDistinctPlus18NameByFilmMaker(String filmMakerGender) {
        Stream<RentalFilm> rentalFilms = this.rentalFilmPersistence.findByFilmMakerGender(filmMakerGender);
        return this.filmCategoryPersistence.findDistinctPlus18ByRentalFilms(rentalFilms);
    }
}
