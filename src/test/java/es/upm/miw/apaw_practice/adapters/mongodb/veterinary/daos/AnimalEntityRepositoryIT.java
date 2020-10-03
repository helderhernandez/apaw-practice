package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.AnimalEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class AnimalEntityRepositoryIT {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    void testFindByName() {
        Optional<AnimalEntity> animal=this.animalRepository.findById("key-1-a");
        assertEquals("Garfield", animal.get().getName());
    }
}
