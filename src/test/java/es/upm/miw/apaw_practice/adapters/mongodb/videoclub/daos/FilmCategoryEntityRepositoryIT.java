package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.FilmCategoryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class FilmCategoryEntityRepositoryIT {
    @Autowired
    private FilmCategoryRepository filmCategoryRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.filmCategoryRepository.findByReference("cat4").isPresent());
        FilmCategoryEntity filmCategory = this.filmCategoryRepository.findByReference("cat4").get();
        assertEquals("cat4", filmCategory.getReference());
        assertEquals("Horror", filmCategory.getName());
        assertTrue(filmCategory.getPlus18());
    }
}
