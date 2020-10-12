package es.upm.miw.apaw_practice.adapters.mongodb.music.daos;


import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.music.entities.AlbumEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AlbumEntityRepositoryIT {
    @Autowired
    private AlbumRepository albumRepository;

    @Test
    void testFindByIsm(){

        assertTrue(this.albumRepository.findByIsmn("42341251").isPresent());
        AlbumEntity album = this.albumRepository.findByIsmn("42341251").get();
        assertEquals("Fly to moon",album.getName());
        assertEquals(LocalDate.of(2020,3,23),album.getPublicationDate());
        assertEquals("an album of pop",album.getDescription());
        assertEquals(0,new BigDecimal("19.99").compareTo(album.getPrice()));
        assertEquals(true,album.getRecommendation());

    }
}
