package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TaxEntityRepositoryIT {

    @Autowired
    private TaxRepository taxRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.taxRepository.findByRefTax("TAX002").isPresent());
        TaxEntity taxEntity = this.taxRepository.findByRefTax("TAX002").get();
        assertEquals("Driving with excess alcohol", taxEntity.getDescription());
        assertEquals(new BigDecimal("400.00"), taxEntity.getPrice());
        assertTrue(this.taxRepository.findAll().stream()
                .anyMatch(tax -> tax.getPaid().equals(Boolean.TRUE)));
        assertTrue(this.taxRepository.findAll().stream()
                .map(TaxEntity::getRefTax)
                .anyMatch(tax -> tax.equals("TAX004")));
    }
}
