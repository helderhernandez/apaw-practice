package es.upm.miw.apaw_practice.adapters.mongodb.padel.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.composite.TreeRackets;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.composite.TreeRacketsComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.composite.TreeRacketsLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class RacketEntityRepositoryIT {
    @Autowired
    private RacketRepository racketRepository;
    private TreeRackets root;
    private TreeRackets subLevel;
    private TreeRackets leaf;

    @BeforeEach
    void ini() {
        System.out.println("DENTROOOO");
        this.root = new TreeRacketsComposite("root");
        this.subLevel = new TreeRacketsComposite("SubLevel1");
        this.leaf = new TreeRacketsLeaf(this.racketRepository.findAllByBrand("BRAND-A").get(0));
        this.root.add(leaf);
        this.subLevel.add(leaf);
        this.subLevel.add(leaf);
        this.subLevel.add(leaf);
        this.root.add(subLevel);
    }

    @Test
    void testRacketsComposite() {
        assertEquals(true, this.root.isComposite());
        assertEquals(this.leaf.name(), this.root.getRacketsName().get(0));
        assertEquals(true, this.subLevel.isComposite());
        assertEquals(3, this.subLevel.getRacketsName().size());
    }

    @Test
    void findAllByBrand(){
        assertEquals(2,this.racketRepository.findAllByBrand("BRAND-A").size());
        assertEquals(1,this.racketRepository.findAllByBrand("BRAND-B").size());
        assertTrue(this.racketRepository.findAllByBrand("BRAND-Z").isEmpty());
        assertEquals("DDDDD",this.racketRepository.findAllByBrand("BRAND-D").get(0).getName());


    }
}
