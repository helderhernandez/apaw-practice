package es.upm.miw.apaw_practice.adapters.mongodb.restaurant.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.restaurant.entities.PhysicalStoreEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PhysicalStoreEntityRepositoryIT {

    @Autowired
    private PhysicalStoreRepository physicalStoreRepository;

    @Test
    void findByAddress(){
        assertTrue(this.physicalStoreRepository.findByAddress("address2").isPresent());
        PhysicalStoreEntity physicalStore = this.physicalStoreRepository.findByAddress("address2").get();
        assertEquals(600, physicalStore.getSize());
        assertFalse(physicalStore.getTerrace());
        assertEquals(LocalDateTime.of(2016,03,14,14,30), physicalStore.getOpening());
    }

    @Test
    void testCreateAndRead(){
        assertTrue(this.physicalStoreRepository.findAll().stream()
                .anyMatch(physicalStore -> "address1".equals(physicalStore.getAddress()) &&
                        Integer.valueOf(500).equals(physicalStore.getSize()) &&
                        Boolean.TRUE.equals(physicalStore.getTerrace()) &&
                        physicalStore.getOpening().isBefore(LocalDateTime.now()) &&
                        LocalDateTime.of(2019, 12, 3,10,00).equals(physicalStore.getOpening())));
    }

}
