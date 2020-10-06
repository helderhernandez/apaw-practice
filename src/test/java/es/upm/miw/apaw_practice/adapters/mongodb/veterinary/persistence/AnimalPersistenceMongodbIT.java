package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class AnimalPersistenceMongodbIT {

    @Autowired
    private AnimalPersistenceMongodb animalPersistence;

    @Test
    void testReadByIdNotFound() {
        assertThrows(NotFoundException.class, () -> this.animalPersistence.readById("key-100-bd"));
    }

    @Test
    void testCreateAndRead() {
        AnimalCreation animalCreation =
                new AnimalCreation("animal-key-1234", "Copito", 2);
        this.animalPersistence.create(animalCreation);
        Animal animalBD = this.animalPersistence.readById("animal-key-1234");
        assertEquals("Copito", animalBD.getName());
        assertEquals(2, animalBD.getAge());
        assertNotNull(animalBD.getDate());
    }
}
