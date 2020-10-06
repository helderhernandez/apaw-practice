package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestConfig
public class ProductPersistenceMongodbIT {

    @Autowired
    private ProductPersistenceMongodb productPersistence;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FactorySeederService factorySeederService;

    @Test
    void testUpdate() {
        ProductEntity product = this.productRepository
                .findBySerialNumber(10000001L)
                .get();
        assertNotNull(product.getId());
        product.setWholesalePrice(new BigDecimal("8.15"));
        this.productPersistence.update(product.toProduct());
        BigDecimal newWholesalePrice = this.productRepository.findBySerialNumber(10000001L).get().getWholesalePrice();
        assertEquals(new BigDecimal("8.15"), newWholesalePrice);
        factorySeederService.deleteAll();
        factorySeederService.seedDatabase();
    }
}

