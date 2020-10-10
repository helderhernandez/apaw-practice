package es.upm.miw.apaw_practice.adapters.mongodb.basketball.dao;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.basketball.daos.CourtRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CourtEntityRepositoryIT {

    @Autowired
    private CourtRepository courtRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.courtRepository.findAll().stream()
                .anyMatch(court ->
                        "Palau Blaugrana".equals(court.getName()) &&
                                7500 == court.getCapacity() &&
                                court.getId() != null &&
                                court.getDateMatch() != null
                ));
    }
}
