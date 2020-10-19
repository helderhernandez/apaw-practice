package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.FurnitureEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite.TreeFurnitures;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite.TreeFurnituresComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.furniture_composite.TreeFurnituresLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CompositeFurnitureEntityRepositoryIT {
    private TreeFurnitures root;

    private TreeFurnitures leaf;

    @BeforeEach
    void ini() {
        TreeFurnitures overFortyEuros;
        TreeFurnitures beforeMay;
        FurnitureEntity furniture1 = new FurnitureEntity("Desk",new BigDecimal("15.90"), LocalDate.of(2021, 11, 13), 10000L);
        FurnitureEntity furniture2 = new FurnitureEntity("Bed", new BigDecimal("89.90"), LocalDate.of(2020, 6, 1),11000L);
        FurnitureEntity furniture3 = new FurnitureEntity("Chair", new BigDecimal("35.60"), LocalDate.of(2020, 5, 23), 13000L);
        FurnitureEntity furniture4 = new FurnitureEntity("Chest", new BigDecimal("79.90"), LocalDate.of(2020, 4, 2), 14000L);
        this.root = new TreeFurnituresComposite("Furnitures");
        this.leaf = new TreeFurnituresLeaf(furniture1);
        this.root.add(this.leaf);
        overFortyEuros = new TreeFurnituresComposite("Over 40 Euros");
        this.root.add(overFortyEuros);
        this.root.add(new TreeFurnituresLeaf(furniture2));
        this.root.add(new TreeFurnituresLeaf(furniture4));
        overFortyEuros.add(new TreeFurnituresLeaf(furniture2));
        overFortyEuros.add(new TreeFurnituresLeaf(furniture4));
        beforeMay = new TreeFurnituresComposite("Before May");
        this.root.add(beforeMay);
        beforeMay.add(new TreeFurnituresLeaf(furniture3));
    }

    @Test
    void testNameOfTreeFurnituresIfLeaf() {
        assertEquals("Desk", this.leaf.getName());
    }

    @Test
    void testNameOfTreeFurnituresIfComposite() {
        assertEquals("Furnitures", this.root.getName());
    }

    @Test
    void testIsComposite() {
        assertTrue(this.root.isComposite());
        assertFalse(this.leaf.isComposite());
    }


}
