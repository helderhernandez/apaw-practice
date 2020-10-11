package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProducts;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProductsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.composite.TreeProductsLeaf;
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

    @Test
    void testTreeProductLeaf() {
        assertFalse(this.leaf1.isComposite());
        assertEquals(1, this.leaf1.numberOfDescendants());
        assertEquals("P0003", this.leaf3.getItemReference());
        assertThrows(UnsupportedOperationException.class,
                () -> this.leaf4.add(new TreeProductsLeaf(this.productRepository.findBySerialNumber(40000001L).get())));
    }

    @Test
    void testTreeProductComposite() {
        assertTrue(this.root.isComposite());
        assertTrue(this.sublevel1.isComposite());
        assertTrue(this.sublevel2.isComposite());

        assertEquals(2, this.root.numberOfDescendants());
        assertEquals(2, this.sublevel1.numberOfDescendants());
        assertEquals(3, this.sublevel2.numberOfDescendants());

        assertEquals("[P0001, P0002]", this.sublevel1.getProductsItemReference().toString());
        assertEquals("[P0003, P0004, P0005]", this.sublevel2.getProductsItemReference().toString());

        assertEquals("blue", this.sublevel1.getItemReference());
        assertEquals("white", this.sublevel2.getItemReference());

        int initialNumberOfLeaves = this.sublevel2.getProductsItemReference().size();
        sublevel2.remove(leaf5);
        assertEquals(initialNumberOfLeaves - 1, this.sublevel2.getProductsItemReference().size());
    }

    @Test
    void testFindBySerialNumber() {
        assertTrue(this.productRepository.findBySerialNumber(30000001L).isPresent());
        ProductEntity product = this.productRepository.findBySerialNumber(30000001L).get();
        assertEquals("P0003", product.getItemReference());
        assertEquals(0, new BigDecimal("106.65").compareTo(product.getWholesalePrice()));
    }
}
