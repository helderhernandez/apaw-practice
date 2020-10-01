package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class ProductEntityRepositoryIT {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.productRepository.findById("P30092047").isPresent());
        ProductEntity product = this.productRepository.findById("P30092047").get();
        assertEquals("product 3", product.getDescription());
        assertEquals(0, new BigDecimal("9.85").compareTo(product.getWholesalePrice()));
    }
}
