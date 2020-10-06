package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class AnimalEntityRepositoryIT {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void testFindById() {
        Optional<AnimalEntity> animal = this.animalRepository.findById("key-1-a");
        assertEquals("Garfield", animal.get().getName());
    }
}
