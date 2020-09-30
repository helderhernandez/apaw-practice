package es.upm.miw.apaw_practice.adapters.mongodb.factory;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
public class FactorySeederService {

    @Autowired
    private ProductRepository productRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Factory Initial Load -----------");

        ProductEntity[] products = {
                new ProductEntity("P30092040", "product 1", new BigDecimal(15.90)),
                new ProductEntity("P30092045", "product 2", new BigDecimal(7.40)),
                new ProductEntity("P30092047", "product 3", new BigDecimal(9.85)),
                new ProductEntity("P30092048", "product 4", new BigDecimal(106.65)),
                new ProductEntity("P30092050", "product 5", new BigDecimal(2560.74))
        };
        this.productRepository.saveAll(Arrays.asList(products));

    }

    public void deleteAll() {
        this.productRepository.deleteAll();
    }
}


