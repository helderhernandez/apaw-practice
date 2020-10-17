package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.MaintanenceItemRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.MaintanenceItemEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class MaintanenceItemEntityRepositoryIT {

    @Autowired
    private MaintanenceItemRepository maintanenceItemRepository;

    @Test
    void testFindByInvoice(){
        assertTrue(this.maintanenceItemRepository.findByInvoice(60005L).isPresent());
        MaintanenceItemEntity maintanenceItem = this.maintanenceItemRepository.findByInvoice(60005L).get();
        assertEquals("5", maintanenceItem.getId());
        assertEquals("Repair manhole cover", maintanenceItem.getItem());
        assertEquals("Road", maintanenceItem.getType());
        assertEquals(LocalDate.of(2020,11,30), maintanenceItem.getTime());
        assertEquals(new BigDecimal("800.00"), maintanenceItem.getFees());
        assertEquals("Barrier", maintanenceItem.getEquipment());
        assertEquals(false,maintanenceItem.getStatus());
    }

    @Test
    void testFindById(){
        assertTrue(this.maintanenceItemRepository.findById("1").isPresent());
        MaintanenceItemEntity maintanenceItem = this.maintanenceItemRepository.findById("1").get();
        assertEquals("Flowerbed", maintanenceItem.getItem());
        assertEquals("Greenbelt", maintanenceItem.getType());
        assertEquals(LocalDate.of(2020,5,30), maintanenceItem.getTime());
        assertEquals(new BigDecimal("1000.00"), maintanenceItem.getFees());
        assertEquals(60001L, maintanenceItem.getInvoice());
        assertEquals("Weeder", maintanenceItem.getEquipment());
        assertEquals(true,maintanenceItem.getStatus());
    }

    @Test
    void testCreateAndRead(){
        assertTrue(this.maintanenceItemRepository.findAll().stream()
                .anyMatch(maintanenceItem ->
                        "Road".equals(maintanenceItem.getType())&&
                                "Repair manhole cover".equals(maintanenceItem.getItem())&&
                                LocalDate.of(2020,11,30).equals(maintanenceItem.getTime())&&
                                "Barrier".equals(maintanenceItem.getEquipment())&&
                                60005L == maintanenceItem.getInvoice()&&
                                new BigDecimal("800.00").equals(maintanenceItem.getFees())&&
                                false == maintanenceItem.getStatus()
                ));
    }
}