package es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyrental.entities.DiscountSportyEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class DiscountSportyEntityRepositoryIT {

    @Autowired
    private DiscountSportyRepository discountSportyRepository;


    @Test
    void testFindById() {
        assertTrue(discountSportyRepository.findById("1").isPresent());
        DiscountSportyEntity discount = this.discountSportyRepository.findById("1").get();
        assertEquals("Large Family", discount.getDescription());
        assertEquals(15.0, discount.getPercentage());
    }


    @Test
    void testDiscountCreateAndGet() {
        DiscountSportyEntity discount = new DiscountSportyEntity("4", "Promotion 10%", 10.0);
        this.discountSportyRepository.save(discount);
        assertTrue(this.discountSportyRepository.findAll().stream().
                anyMatch(customer -> "4".equals(discount.getIdDiscount())
                ));
    }

    @Test
    void testDiscountSet() {
        assertTrue(discountSportyRepository.findById("3").isPresent());
        DiscountSportyEntity discount = this.discountSportyRepository.findById("2").get();
        discount.setDescription("Promotion 30%");
        discount.setPercentage(30.0);

        assertEquals("Promotion 30%", discount.getDescription());
        assertEquals(30.0, discount.getPercentage());
    }
}
