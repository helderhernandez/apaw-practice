package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.VideoclubSeederService;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import es.upm.miw.apaw_practice.domain.models.videoclub.FilmCategory;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.FilmCategoryPersistence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

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

}
