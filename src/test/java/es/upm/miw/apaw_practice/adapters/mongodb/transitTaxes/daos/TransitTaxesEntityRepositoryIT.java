package es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transitTaxes.entities.TransitTaxesEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TransitTaxesEntityRepositoryIT {

    @Autowired
    private TransitTaxesRepository transitTaxesRepository;

    @Test
    void testCreateAndRead() {

        TransitTaxesEntity transitTaxesEntity = this.transitTaxesRepository.findByRefTaxes("TAX002").get();
        assertEquals("Driving with excess alcohol",transitTaxesEntity.getDescription());
        assertEquals(new BigDecimal("400.00"),transitTaxesEntity.getPrice());

        assertTrue(this.transitTaxesRepository.findAll().stream()
                .anyMatch( tax -> tax.getPaid().equals(Boolean.TRUE)));

        assertTrue(this.transitTaxesRepository.findAll().stream()
        .map(TransitTaxesEntity :: getRefTaxes)
        .anyMatch(tax -> tax.equals("TAX004")));
    }
}
