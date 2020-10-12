package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.SportyRentalSeederService;
import es.upm.miw.apaw_practice.domain.models.sportyRental.DiscountSporty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
class DiscountSportyPersistenceMongodbIT {

    @Autowired
    private DiscountSportyPersistenceMongodb discountSportyPersistenceMongodb;

    @Autowired
    private SportyRentalSeederService sportyRentalSeederService;

    @Test
    void testDescriptionUpdateAndReset() {

        Optional<DiscountSporty> discountSportyOptional = this.discountSportyPersistenceMongodb.readAll().filter(discount -> "3".equals(discount.getIdDiscount())).findFirst();
        assertNotNull(discountSportyOptional);
        assertTrue(discountSportyOptional.isPresent());
        DiscountSporty discountSporty = discountSportyOptional.get();


        discountSporty = discountSportyPersistenceMongodb.updateDescription(discountSporty.getIdDiscount(), 30.0);
        assertEquals("3", discountSporty.getIdDiscount());
        assertEquals("Impairment", discountSporty.getDescription());
        assertEquals(30.0, discountSporty.getPercentage());

        discountSportyPersistenceMongodb.updateDescription(discountSporty.getIdDiscount(), 40.0);
    }

}
