package es.upm.miw.apaw_practice.adapters.mongodb.transittaxes.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestConfig
public class TaxPersistenceMongodbIT {

    @Autowired
    private TaxPersistenceMongodb taxPersistenceMongodb;

    @Test
    void testCreateAndRead() {
        Tax tax = new Tax();
        tax.setRefTax("TAX008");
        tax.setDescription("Speeding");
        tax.setPrice(new BigDecimal("150.00"));
        tax.setPaid(false);
        Tax taxCreated = taxPersistenceMongodb.create(tax);
        Tax taxBD = this.taxPersistenceMongodb.findByRefTax("TAX008");
        assertEquals(taxCreated.getDescription(), taxBD.getDescription());
        assertEquals(taxCreated.getPaid(), taxBD.getPaid());
        assertEquals(taxCreated.getPrice(), taxBD.getPrice());
        assertEquals(taxCreated.getRefTax(), tax.getRefTax());
    }
    @Test
    void testFindPriceTotalTaxesByIdCar(){
        BigDecimal total = taxPersistenceMongodb.findPriceTotalTaxesByIdCar("02").getPrice();
        assertEquals(new BigDecimal("650.00"),total);

        BigDecimal total2 = taxPersistenceMongodb.findPriceTotalTaxesByIdCar("01").getPrice();
        assertEquals(new BigDecimal("500.00"),total2);

        BigDecimal total3 = taxPersistenceMongodb.findPriceTotalTaxesByIdCar("03").getPrice();
        assertEquals(new BigDecimal("0.00"),total3);
    }
}
