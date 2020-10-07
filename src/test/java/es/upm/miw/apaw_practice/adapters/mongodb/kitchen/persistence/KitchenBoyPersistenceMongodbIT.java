package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.KitchenSeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos.KitchenBoyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class KitchenBoyPersistenceMongodbIT {

    @Autowired
    private KitchenBoyPersistenceMongodb kitchenBoyPersistence;

    @Autowired
    private KitchenBoyRepository kitchenBoyRepository;

    @Autowired
    private KitchenSeederService kitchenSeederService;

    @Test
    void testDelete() {
        assertTrue(!this.kitchenBoyRepository.findByDni("12345678A").isEmpty());
        this.kitchenBoyPersistence.delete("12345678A");
        assertTrue(this.kitchenBoyRepository.findByDni("12345678A").isEmpty());

        this.kitchenSeederService.deleteAll();
        this.kitchenSeederService.seedDatabase();
    }
}
