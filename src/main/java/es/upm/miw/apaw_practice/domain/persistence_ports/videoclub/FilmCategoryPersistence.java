package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface FilmCategoryPersistence {

    FilmCategory readByReference(String reference);

    FilmCategory update(FilmCategory filmCategory);

    Stream<String> findDistinctPlus18ByRentalFilms(Stream<RentalFilm> rentalFilms);
}
