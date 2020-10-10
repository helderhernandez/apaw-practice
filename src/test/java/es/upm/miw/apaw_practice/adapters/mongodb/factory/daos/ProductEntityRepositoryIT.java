package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProducts;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProductsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProductsLeaf;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.composite.TreeRackets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class ProductEntityRepositoryIT {

    @Autowired
    private ProductRepository productRepository;
    private TreeProducts root;
    private TreeProducts sublevel1;
    private TreeProducts sublevel2;
    private TreeProducts leaf1;
    private TreeProducts leaf2;
    private TreeProducts leaf3;
    private TreeProducts leaf4;
    private TreeProducts leaf5;

    @BeforeEach
    void ini() {

        this.root = new TreeProductsComposite("keyboard");
        this.sublevel1 = new TreeProductsComposite("blue");
        this.sublevel2 = new TreeProductsComposite("white");

        this.leaf1 = new TreeProductsLeaf(this.productRepository.findBySerialNumber(10000001L).get());
        this.leaf2 = new TreeProductsLeaf(this.productRepository.findBySerialNumber(20000001L).get());
        this.leaf3 = new TreeProductsLeaf(this.productRepository.findBySerialNumber(30000001L).get());
        this.leaf4 = new TreeProductsLeaf(this.productRepository.findBySerialNumber(40000001L).get());
        this.leaf5 = new TreeProductsLeaf(this.productRepository.findBySerialNumber(50000001L).get());

        this.root.add(this.sublevel1);
        this.sublevel1.add(leaf1);
        this.sublevel1.add(leaf2);
        this.root.add(this.sublevel2);
        this.sublevel2.add(leaf3);
        this.sublevel2.add(leaf4);
        this.sublevel2.add(leaf5);
    }
/*
    @Test

    void testRacketsComposite() {
        assertEquals(true, this.root.isComposite());
        assertEquals(this.leaf1.getItemReference(), this.root.getProductsItemReference().get(0));
        assertEquals("0,1Kg", this.leaf2.);
        assertEquals(true, this.subLevel.isComposite());
        assertEquals(4, this.subLevel.getRacketsName().size());

        subLevel.remove(leaf);
        assertEquals(3, this.subLevel.getRacketsName().size());
    }

    @Test
    void testFindBySerialNumber() {
        assertTrue(this.productRepository.findBySerialNumber(30000001L).isPresent());
        ProductEntity product = this.productRepository.findBySerialNumber(30000001L).get();
        assertEquals("P0003", product.getItemReference());
        assertEquals(0, new BigDecimal("106.65").compareTo(product.getWholesalePrice()));
    }

 */
}
