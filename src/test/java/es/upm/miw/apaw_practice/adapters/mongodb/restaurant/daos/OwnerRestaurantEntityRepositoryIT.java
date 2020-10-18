package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class OwnerRestaurantEntityRepositoryIT {

    @Autowired
    private OwnerRestaurantRepository ownerRepository;

    @Test
    void testCreateAndRead(){
        assertTrue(this.ownerRepository.findAll().stream()
                .anyMatch(owner -> "Lara".equals(owner.getName()) &&
                        "Martinez".equals(owner.getFamilyName())));
    }
}
