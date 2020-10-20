package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.KitchenBoyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class KitchenBoyEntityRepositoryIT {
    @Autowired
    private KitchenBoyRepository kitchenBoyRepository;

    private KitchenBoyEntity kitchenBoy;

    @BeforeEach
    void before(){
        assertTrue(this.kitchenBoyRepository.findByDni("12345678A").isPresent());
        kitchenBoy = this.kitchenBoyRepository.findByDni("12345678A").get();
    }

    @Test
    void testSetAndGet(){
        kitchenBoy.setDni("99922211B");
        assertEquals("99922211B", kitchenBoy.getDni());

        assertEquals(3, kitchenBoy.getWorkExperienceYears());
        kitchenBoy.setWorkExperienceYears(4);
        assertEquals(4, kitchenBoy.getWorkExperienceYears());

        assertEquals("Calabaza", kitchenBoy.getIngredientToWorkOn().getName());
        kitchenBoy.setIngredientToWorkOn(new IngredientEntity("Ajo", new BigDecimal(0.5), 0.2));
        assertEquals("Ajo", kitchenBoy.getIngredientToWorkOn().getName());
    }

    @Test
    void testEquals(){
        KitchenBoyEntity equalKitchenBoy = new KitchenBoyEntity("12345678A", 3, kitchenBoy.getIngredientToWorkOn());
        assertEquals(kitchenBoy, equalKitchenBoy);
        assertNotEquals(kitchenBoy, kitchenBoyRepository.findByDni("50129911B")
                .orElseThrow(() -> new NotFoundException("KitchenBoy DNI 50129911B")));
    }
}
