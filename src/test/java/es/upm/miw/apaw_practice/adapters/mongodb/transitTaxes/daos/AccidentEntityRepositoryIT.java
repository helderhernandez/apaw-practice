package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.AccidentEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AccidentEntityRepositoryIT {

    @Autowired
    private AccidentRepository accidentRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.accidentRepository.findAll().stream()
                .anyMatch(accidentEntity -> accidentEntity.getPlace().equals("Madrid")));
        assertTrue(this.accidentRepository.findAll().stream()
                .anyMatch(accidentEntity -> accidentEntity.getDate()
                        .isBefore(LocalDateTime.of(2018, 12, 30, 12, 00))));
    }
}
