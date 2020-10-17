package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDOwnerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CDOwnerEntityRepositoryIT {
    @Autowired
    private CDOwnerRepository ownerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.ownerRepository.findAll().stream()
                .anyMatch(owner ->
                        owner.getName().equals("Manuel") &&
                                owner.getSurname().equals("Zapata") &&
                                717383928L == owner.getTelephone())
        );
    }
}
