package es.upm.miw.apaw_practice.adapters.mongodb.kitchen.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.ChefEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.IngredientEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.kitchen.entities.KitchenBoyEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ChefEntityRepositoryIT {
    @Autowired
    private ChefRepository chefRepository;

    private ChefEntity chef;

    @BeforeEach
    void before() {
        assertTrue(this.chefRepository.findByDni("44411122F").isPresent());
        chef = this.chefRepository.findByDni("44411122F").get();
    }

    @Test
    void testSetAndGet() {
        chef.setDni("11123455A");
        assertEquals("11123455A", chef.getDni());

        assertEquals(0, chef.getRecipesFinished());
        chef.setRecipesFinished(5);
        assertEquals(5, chef.getRecipesFinished());

        List<KitchenBoyEntity> newKitchenBoyList = chef.getKitchenBoys();
        newKitchenBoyList.add(new KitchenBoyEntity("89811122B", 2, new IngredientEntity("Pez", new BigDecimal(35), 0.1)));
        chef.setKitchenBoys(newKitchenBoyList);

        assertTrue(chef.getKitchenBoys().stream()
                .map(kitchenBoy -> kitchenBoy.getDni())
                .collect(Collectors.toList())
                .containsAll(Arrays.asList("12345678A", "50129911B", "89811122B")));
    }

    @Test
    void testEquals() {
        ChefEntity equalChef = new ChefEntity("44411122F", chef.getKitchenBoys());
        assertTrue(chef.equals(equalChef));
    }
}
