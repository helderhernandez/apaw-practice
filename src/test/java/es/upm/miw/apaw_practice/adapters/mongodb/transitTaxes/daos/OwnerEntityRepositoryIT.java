package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.AccidentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.OwnerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class OwnerEntityRepositoryIT {

    @Autowired
    private OwnerRepository ownerRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(ownerRepository.findByDni("00000000C").isPresent());
        OwnerEntity ownerEntity = ownerRepository.findByDni("00000000C").get();
        assertEquals("Jhon", ownerEntity.getName());
        assertEquals("Smith", ownerEntity.getFamilyName());
    }
}
