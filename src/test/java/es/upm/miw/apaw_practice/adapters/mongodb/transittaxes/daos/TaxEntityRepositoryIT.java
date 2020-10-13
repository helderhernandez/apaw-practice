package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.entities.TaxEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class TaxEntityRepositoryIT {

    @Autowired
    private TaxRepository taxRepository;

    @Test
    void testTaxEntity() {
        TaxEntity tax = TaxEntity.builder().idTax().refTax("TAX008").price(new BigDecimal("600.00")).description("Driving without a driver's license").paid(false).build();
        tax.setDescription("Smoking while driving");
        tax.setPaid(true);
        tax.setPrice(new BigDecimal("20.00"));
        tax.setRefTax("TAX000");
        assertNotEquals("TAX008", tax.getRefTax());
        assertNotEquals("Driving without a driver's license", tax.getDescription());
    }

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
