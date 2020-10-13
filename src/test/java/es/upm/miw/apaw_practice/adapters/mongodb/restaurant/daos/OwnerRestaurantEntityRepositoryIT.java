package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class OwnerRestaurantEntityRepositoryIT {

    @Autowired
    private OwnerRestaurantRepository ownerRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.ownerRepository.findAll().stream()
                .anyMatch(owner -> "name1".equals(owner.getName()) &&
                        "familyName1".equals(owner.getFamilyName())));
    }
}
