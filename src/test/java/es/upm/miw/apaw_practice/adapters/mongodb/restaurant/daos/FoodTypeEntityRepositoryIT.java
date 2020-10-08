package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class FoodTypeEntityRepositoryIT {

    @Autowired
    private FoodTypeRepository foodTypeRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.foodTypeRepository.findAll().stream()
                .anyMatch(foodType -> "type1".equals(foodType.getType()) &&
                          Boolean.FALSE.equals(foodType.getSpicy())));
    }
}
