package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ArtistEntityRepositoryIT {
    @Autowired
    private ArtistRepository artistRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.artistRepository.findById("AAA1").isPresent());
        ArtistEntity artist = this.artistRepository.findById("AAA4").get();
        assertEquals("AAA4", artist.getId());
        assertEquals("Artist4", artist.getName());
        assertEquals("Artist_Surname4", artist.getSurname());
        assertEquals("Country4", artist.getCounty());
    }

}
