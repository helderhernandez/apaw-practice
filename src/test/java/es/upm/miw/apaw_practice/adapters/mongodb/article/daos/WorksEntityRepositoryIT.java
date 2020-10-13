package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class WorksEntityRepositoryIT {

    @Autowired
    private WorksRepository worksRepository;

    @Test
    void testFindById() {
        assertTrue(this.worksRepository.findById("79803").isPresent());
        WorksEntity works = this.worksRepository.findById("79803").get();
        assertEquals("Journey to the West", works.getName());
        assertEquals("45848798", works.getIsmn());
        assertEquals(LocalDate.of(2013,7,26), works.getPublicationdate());
        assertEquals("masterpiece", works.getDescription());
        assertEquals(new BigDecimal("15.99"), works.getPrice());
        assertEquals((byte) 5, works.getGrade());

    }
}
