package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SurgeryEntityRepositoryIT {

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Test
    void testAndCreate() {
        assertTrue(this.surgeryRepository.findAll().stream()
                .anyMatch(surgery ->
                        "key-1-a".equals(surgery.getId()) &&
                                "heart".equals(surgery.getType()) &&
                                new BigDecimal("1249.99").equals(surgery.getPrice()) &&
                                "Sonsoles".equals(surgery.getVeterinarians().get(0).getName()) &&
                                "Garfield".equals(surgery.getAnimals().get(0).getName()))
        );
    }
}
