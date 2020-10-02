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
    void testFindBySerialNumber() {
        assertTrue(this.productRepository.findBySerialNumber(30000001L).isPresent());
        ProductEntity product = this.productRepository.findBySerialNumber(30000001L).get();
        assertEquals("P0003", product.getItemReference());
        assertEquals(0, new BigDecimal("106.65").compareTo(product.getWholesalePrice()));
    }
}
