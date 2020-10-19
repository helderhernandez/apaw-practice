package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.CDOwnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite.TreeCDOwner;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite.TreeCDOwnerComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.entities.composite.TreeCDOwnerLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class CDOwnerEntityRepositoryIT {
    @Autowired
    private CDOwnerRepository ownerRepository;

    private TreeCDOwner rootOwner;
    private TreeCDOwner subLevelOwner1;
    private TreeCDOwner subLevelOwner2;
    private TreeCDOwner leafOwner1;
    private TreeCDOwner leafOwner2;
    private TreeCDOwner leafOwner3;
    private TreeCDOwner leafOwner4;
    private TreeCDOwner leafOwner5;

    @BeforeEach
    void init() {
        this.rootOwner = new TreeCDOwnerComposite();
        this.subLevelOwner1 = new TreeCDOwnerComposite();
        this.subLevelOwner2 = new TreeCDOwnerComposite();

        this.leafOwner1 = new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(0));
        this.leafOwner2 = new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(1));
        this.leafOwner3 = new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(2));
        this.leafOwner4 = new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(3));
        this.leafOwner5 = new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(4));

        this.rootOwner.add(this.subLevelOwner1);
        this.subLevelOwner1.add(leafOwner1);
        this.subLevelOwner1.add(leafOwner2);
        this.rootOwner.add(this.subLevelOwner2);
        this.subLevelOwner2.add(leafOwner3);
        this.subLevelOwner2.add(leafOwner4);
        this.subLevelOwner2.add(leafOwner5);
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.ownerRepository.findAll().stream()
                .anyMatch(owner ->
                        owner.getName().equals("Manuel") &&
                                owner.getSurname().equals("Zapata") &&
                                717383928L == owner.getTelephone())
        );
    }

    @Test
    void entityCreationTest(){
        CDOwnerEntity entity = new CDOwnerEntity();
        entity.setName("Pablo");
        entity.setSurname("Coronado");
        entity.setTelephone(666555666L);
        assertEquals("Pablo", entity.getName());
        assertEquals("Coronado", entity.getSurname());
        assertEquals(666555666L, entity.getTelephone());
    }

    @Test
    void testCDOwnersLeaves() {
        assertEquals(1, this.leafOwner1.numberOfDescendants());
        assertFalse(this.leafOwner1.isComposite());
        assertThrows(UnsupportedOperationException.class, () -> this.leafOwner1.add(new TreeCDOwnerLeaf(this.ownerRepository.findAll().get(4))));
    }

    @Test
    void testTreeProductComposite() {
        assertTrue(this.rootOwner.isComposite());
        assertTrue(this.subLevelOwner1.isComposite());
        assertTrue(this.subLevelOwner2.isComposite());
    }
}
