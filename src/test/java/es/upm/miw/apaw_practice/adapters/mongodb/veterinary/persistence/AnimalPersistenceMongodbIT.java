package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.VeterinarySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.AnimalRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos.SurgeryRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.veterinary.Animal;
import es.upm.miw.apaw_practice.domain.models.veterinary.AnimalCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class AnimalPersistenceMongodbIT {

    @Autowired
    private AnimalPersistenceMongodb animalPersistence;

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SurgeryRepository surgeryRepository;

    @Autowired
    private VeterinarySeederService veterinarySeederService;

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

    @Test
    void testUpdateAge() {
        AnimalEntity animalEntity = this.animalRepository
                .findById("key-1-a")
                .get();
        assertNotNull(animalEntity.getAge());
        this.animalPersistence.updateAge(animalEntity.getId(), 7);
        assertEquals(7, animalRepository.findById("key-1-a").get().getAge());
        veterinarySeederService.deleteAll();
        veterinarySeederService.seedDatabase();
    }
}
