package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.MaintanenceItemRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.ProprietorRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.MaintanenceItemEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MaintanenceItemEntityRepositoryIT {

    @Autowired
    private MaintanenceItemRepository maintanenceItemRepository;

    @Test
    void testFindByInvoice() {
        assertTrue(this.maintanenceItemRepository.findByInvoice(60005L).isPresent());
        MaintanenceItemEntity maintanenceItem = this.maintanenceItemRepository.findByInvoice(60005L).get();
        assertEquals("Repair manhole cover", maintanenceItem.getItem());
        assertEquals("Road", maintanenceItem.getType());
        assertEquals(LocalDate.of(2020,11,30), maintanenceItem.getTime());
        assertEquals(new BigDecimal("800.00"), maintanenceItem.getFees());
        assertEquals("Barrier", maintanenceItem.getEquipment());
        assertEquals(false,maintanenceItem.getStatus());
    }
}
