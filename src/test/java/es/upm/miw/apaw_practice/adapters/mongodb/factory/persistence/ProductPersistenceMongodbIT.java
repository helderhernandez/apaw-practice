package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.models.factory.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        product.setWholesalePrice(new BigDecimal("7.40"));
        this.productPersistence.update(product.toProduct());
    }

    @Test
    void testActiveMachines() {
        List<Machine> activeMachines = this.productPersistence.activeMachines();

        assertEquals(800500L, activeMachines.get(0).getSerialNumber());
        assertEquals(700500L, activeMachines.get(1).getSerialNumber());
    }

    @Test
    void testProductsInActiveMachines() {
        List<Long> productsActiveMachines = this.productPersistence.productsInActiveMachines();

        assertEquals(10000001, productsActiveMachines.get(0));
        assertEquals(20000001, productsActiveMachines.get(1));
        assertEquals(30000001, productsActiveMachines.get(2));
        assertEquals(40000001, productsActiveMachines.get(3));
    }

    @Test
    void testFindProductsWithAnActiveMachineAndAWholesalePriceGreaterThan() {
        Stream<Product> products = this.productPersistence.findProductsWithAnActiveMachineAndAWholesalePriceGreaterThan(new BigDecimal("50.50"));
        List<Product> productList = products.collect(Collectors.toList());

        assertEquals(30000001L, productList.get(0).getSerialNumber());
        assertEquals(new BigDecimal("106.65"), productList.get(0).getWholesalePrice());
        assertEquals("P0004", productList.get(1).getItemReference());
    }
}

