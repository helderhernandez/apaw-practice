package es.upm.miw.apaw_practice.adapters.mongodb.museum.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.ArtistEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.museum.entities.PatronEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PatronEntityRepositoryIT {

    @Autowired
    private PatronRepository patronRepository;

    @Test
    void estCreateAndRead() {
        assertTrue(this.patronRepository.findById("PAT2").isPresent());
        PatronEntity patron = this.patronRepository.findById("PAT1").get();
        assertEquals("PAT1", patron.getId());
        assertEquals("Patron_1", patron.getName());
        assertEquals("Patron_Surname1", patron.getSurname());
        assertEquals(new BigDecimal("1000.00"), patron.getContribution());
    }
}
