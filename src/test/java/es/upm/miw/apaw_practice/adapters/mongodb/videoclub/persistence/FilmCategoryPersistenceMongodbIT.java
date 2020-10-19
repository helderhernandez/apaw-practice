package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmMaker;
import es.upm.miw.apaw_practice.domain.models.videoclub.RentalFilm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FilmCategoryPersistenceMongodbIT {

    @Autowired
    private VideoclubSeederService videoclubSeederService;

    @Autowired
    private FilmCategoryPersistenceMongodb filmCategoryPersistenceMongodb;

    @AfterEach
    void resetBBDD() {
        this.videoclubSeederService.deleteAll();
        this.videoclubSeederService.seedDatabase();
    }

    @Test
    void testUpdatePlus18() {
        FilmCategory filmCategory = this.filmCategoryPersistenceMongodb.readByReference("cat1");
        assertNotNull(filmCategory);
        assertNotNull(filmCategory.getReference());
        assertFalse(filmCategory.getPlus18());
        filmCategory.setPlus18(true);
        this.filmCategoryPersistenceMongodb.update(filmCategory);
        filmCategory = this.filmCategoryPersistenceMongodb.readByReference("cat1");
        assertTrue(filmCategory.getPlus18());
    }

    @Test
    void testFindDistinctPlus18ByRentalFilms() {
        FilmCategory filmCategory1 = new FilmCategory("cat3", "Thriller", false);
        FilmCategory filmCategory2 = new FilmCategory("cat6", "War", true);
        FilmMaker filmMaker = new FilmMaker("filmMaker5", "Kathryn Bigelow", LocalDate.of(1970, 5, 29), "F");
        RentalFilm rentalFilm1 = new RentalFilm("5555", "Zero Dark Thirty", 2012, filmMaker, Arrays.asList(filmCategory1));
        RentalFilm rentalFilm2 = new RentalFilm("6666", "The Hurt Locker", 2015, filmMaker, Arrays.asList(filmCategory2));
        Stream<RentalFilm> rentalFilms = List.of(rentalFilm1, rentalFilm2).stream();

        Stream<String> filmCategoriesNames = this.filmCategoryPersistenceMongodb
                .findDistinctPlus18ByRentalFilms(rentalFilms);
        List<String> filmCategoriesNamesList = filmCategoriesNames.collect(Collectors.toList());

        assertEquals("War", filmCategoriesNamesList.get(0));
    }
}
