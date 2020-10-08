package es.upm.miw.apaw_practice.adapters.mongodb.movie.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite.TreeFilmDirectors;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite.TreeFilmDirectorsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite.TreeFilmDirectorsLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CompositeFilmDirectorEntityRepositoryIT {

    private TreeFilmDirectors root;

    private TreeFilmDirectors oscarWinners;

    private TreeFilmDirectors leaf;

    @BeforeEach
    void ini() {
        TreeFilmDirectors overThirtyYears;
        TreeFilmDirectors femaleGender;
        FilmDirectorEntity director1 = FilmDirectorEntity.builder().name("Hector").fulName("Munoz Merida").age(22).build();
        FilmDirectorEntity director2 = FilmDirectorEntity.builder().name("Luis").fulName("Franco Perez").age(55).build();
        FilmDirectorEntity director3 = FilmDirectorEntity.builder().name("Marta").fulName("Gomez Gomez").age(28).build();
        FilmDirectorEntity director4 = FilmDirectorEntity.builder().name("Pedro").fulName("Munoz Roda").age(30).build();
        FilmDirectorEntity director5 = FilmDirectorEntity.builder().name("Jose").fulName("Luis Rodriguez").age(38).build();
        this.root = new TreeFilmDirectorsComposite("Horror genre");

        this.leaf = new TreeFilmDirectorsLeaf(director1);
        this.root.add(this.leaf);
        overThirtyYears = new TreeFilmDirectorsComposite("Over 30 years old");
        this.root.add(overThirtyYears);
        this.root.add(new TreeFilmDirectorsLeaf(director2));
        this.root.add(new TreeFilmDirectorsLeaf(director4));
        this.oscarWinners = new TreeFilmDirectorsComposite("Oscar winners");
        overThirtyYears.add(oscarWinners);
        overThirtyYears.add(new TreeFilmDirectorsLeaf(director3));
        overThirtyYears.add(new TreeFilmDirectorsLeaf(director5));
        femaleGender = new TreeFilmDirectorsComposite("Female gender");
        overThirtyYears.add(femaleGender);
        this.oscarWinners.add(new TreeFilmDirectorsLeaf(director3));
        this.oscarWinners.add(new TreeFilmDirectorsLeaf(director1));
        femaleGender.add(new TreeFilmDirectorsLeaf(director3));
    }

    @Test
    void testNameOfTreeFilmDirectorsIfLeaf() {
        assertEquals("Hector", this.leaf.getName());
    }

   @Test
    void testNameOfTreeFilmDirectorsIfComposite() {
        assertEquals("Horror genre", this.root.getName());
        assertEquals("Oscar winners", this.oscarWinners.getName());
    }

    @Test
    void testIsComposite() {
        assertTrue(this.oscarWinners.isComposite());
        assertFalse(this.leaf.isComposite());
    }

    @Test
    void testAddAndRemoveLeaf() {
        assertTrue(this.oscarWinners.isComposite());
        assertFalse(this.leaf.isComposite());
    }

}
