package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SpecialityEntityRepositoryIT {

    @Autowired
    private SpecialityRepository specialityRepository;


    @Test
    void testCreateAndRead() {
        assertTrue(this.specialityRepository.findById("spec3").isPresent());
        SpecialityEntity speciality = this.specialityRepository.findById("spec3").get();
        assertEquals("Indoor Cycling", speciality.getTitle());
        assertFalse(speciality.isRecomended());
        assertEquals(30, speciality.getDuration());
    }

}
