package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.VeterinarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.SurgeryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class SurgeryPersistenceMongodbIT {

    @Autowired
    private SurgeryPersistenceMongodb surgeryPersistence;


    @Test
    void testFindAnimalByName() {
        List<String> names = List.of("Sonsoles", "Joaquin");
        assertTrue(surgeryPersistence.findAnimalByName("Garfield").containsAll(names));
    }

    @Test
    void testFindAnimalByType() {
        List<String> names = List.of("Manuel", "Ulises");
        assertTrue(surgeryPersistence.findAnimalByType("spinal").containsAll(names));
    }
}
