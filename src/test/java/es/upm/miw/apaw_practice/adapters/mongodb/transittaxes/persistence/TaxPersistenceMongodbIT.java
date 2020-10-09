package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.TransitTaxesSeederService;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.models.transittaxes.TaxCreation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class TaxPersistenceMongodbIT {

    @Autowired
    private TaxPersistenceMongodb taxPersistenceMongodb;
    @Autowired
    private TransitTaxesSeederService transitTaxesSeederService;

    @Test
    void testCreateAndRead(){
        TaxCreation taxCreation = new TaxCreation("TAX008","Speeding",new BigDecimal("150.00"), false);
        Tax taxCreated = taxPersistenceMongodb.create(taxCreation);
        Tax tax = this.taxPersistenceMongodb.findByRefTax("TAX008");
        assertEquals(taxCreated.getDescription(),tax.getDescription());
        assertEquals(taxCreated.getPaid(),tax.getPaid());
        assertEquals(taxCreated.getPrice(),tax.getPrice());
        assertEquals(taxCreated.getId(),tax.getId());
    }
}
