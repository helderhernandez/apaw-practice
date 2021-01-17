package es.upm.miw.apaw_practice.adapters.mongodb.studio.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite.TreeDesigns;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite.TreeDesignsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.composite.TreeDesignsLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class DesignEntityRepositoryIT {
    @Autowired
    private DesignRepository designRepository;
    private TreeDesigns root;
    private TreeDesigns sublevel1;
    private TreeDesigns sublevel2;
    private TreeDesigns leaf1;
    private TreeDesigns leaf2;
    private TreeDesigns leaf3;

    @BeforeEach
    void ini() {
        this.root = new TreeDesignsComposite("single", new BigDecimal("300.00"));
        this.sublevel1 = new TreeDesignsComposite("single", new BigDecimal("300.00"));
        this.sublevel2 = new TreeDesignsComposite("single", new BigDecimal("300.00"));
        this.leaf1 = new TreeDesignsLeaf(this.designRepository.findAll().get(0));
        this.leaf2 = new TreeDesignsLeaf(this.designRepository.findAll().get(1));
        this.leaf3 = new TreeDesignsLeaf(this.designRepository.findAll().get(2));

        this.root.add(this.sublevel1);
        this.sublevel1.add(this.leaf1);
        this.sublevel1.add(this.leaf2);
        this.root.add(this.sublevel2);
        this.sublevel2.add(this.leaf3);
    }

    @Test
    void testTreeDesignLeaf() {
        assertFalse(this.leaf1.isComposite());
        assertEquals(1, this.leaf2.numberOfDescendants());
        assertEquals("available", this.leaf3.getType());
    }

    @Test
    void testTreeDesignComposite() {
        assertTrue(this.root.isComposite());
        assertTrue(this.sublevel1.isComposite());
        assertTrue(this.sublevel2.isComposite());

        assertEquals(2, this.root.numberOfDescendants());
        assertEquals(2, this.sublevel1.numberOfDescendants());
        assertEquals(1, this.sublevel2.numberOfDescendants());
    }

    @Test
    void testCreateAndRead() {
        assertTrue(
            this.designRepository
                .findAll()
                .stream()
                .anyMatch(design->
                    design.getCost().equals(new BigDecimal("250.00")) &&
                    design.getFinished().equals(Boolean.FALSE) &&
                    design.getStyle().equals("American Traditional") &&
                    design.getType().equals("collaborative") &&
                    design.getTattoistEntities().get(0).getNickname().equals("JC") &&
                    design.getTattoistEntities().get(0).getName().equals("Joseph Company")
                ));
    }
}
