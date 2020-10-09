package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
        product.setWholesalePrice(new BigDecimal("7.40"));
        this.productPersistence.update(product.toProduct());
    }


    @Test
    void testCompareTwoPrices() {
        BigDecimal price1 = new BigDecimal("5.59");
        BigDecimal price2 = new BigDecimal("10.59");
        BigDecimal price3 = new BigDecimal("15.59");

        assertFalse(this.productPersistence.compareTwoPrices(price1, price2));
        assertTrue(this.productPersistence.compareTwoPrices(price3, price2));
    }

    @Test
    void testProductsWithAWholesalePriceGreaterThan() {
        BigDecimal price1 = new BigDecimal("5.50");
        BigDecimal price2 = new BigDecimal("50.50");
        BigDecimal price3 = new BigDecimal("500.50");
        BigDecimal price4 = new BigDecimal("5000.50");

        List<Long> x1 = this.productPersistence.productsWithAWholesalePriceGreaterThan(price1);
        System.out.println("Products over Price 1 >>>> " + x1);
        List<Long> x2 = this.productPersistence.productsWithAWholesalePriceGreaterThan(price2);
        System.out.println("Products over Price 2 >>>> " + x2);
        List<Long> x3 = this.productPersistence.productsWithAWholesalePriceGreaterThan(price3);
        System.out.println("Products over Price 3 >>>> " + x3);
        List<Long> x4 = this.productPersistence.productsWithAWholesalePriceGreaterThan(price4);
        System.out.println("Products over Price 4 >>>> " + x4);
    }

    @Test
    void testActiveMachines() {
        List<Long> activeMachines = this.productPersistence.activeMachines();
        System.out.println("Active machines >>>> " + activeMachines);
    }
}

