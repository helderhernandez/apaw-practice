package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite.TreeLikesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite.TreeLikesEntityComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.composite.TreeLikesEntityLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class LikesEntityRepositoryIT {

    @Autowired
    private LikesRepository likesRepository;
    private LikesEntity likes;

    private TreeLikesEntity root;
    private TreeLikesEntity leaf1;
    private TreeLikesEntity sub1;
    private TreeLikesEntity sub2;
    private TreeLikesEntity leaf11;
    private TreeLikesEntity leaf12;
    private TreeLikesEntity leaf21;


    @BeforeEach
    void before() {
        assertTrue(this.likesRepository.findById("likes-01").isPresent());
        likes = this.likesRepository.findById("likes-01").get();

        LikesEntity auxLikesEntity = new LikesEntity("id1", "name1", "description1");


        this.root = new TreeLikesEntityComposite("root", "root");
        this.leaf1 = new TreeLikesEntityLeaf(auxLikesEntity);

        this.sub1 = new TreeLikesEntityComposite("sub1", "subn1");
        auxLikesEntity = new LikesEntity("id2", "name2", "description2");
        this.leaf11 = new TreeLikesEntityLeaf(auxLikesEntity);
        this.sub1.add(leaf11);
        auxLikesEntity = new LikesEntity("id3", "name3", "description3");
        this.leaf12 = new TreeLikesEntityLeaf(auxLikesEntity);
        this.sub1.add(leaf12);

        this.sub2 = new TreeLikesEntityComposite("sub2", "sub2");
        auxLikesEntity = new LikesEntity("id4", "name4", "description4");
        this.leaf21 = new TreeLikesEntityLeaf(auxLikesEntity);
        this.sub2.add(leaf21);

    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.likesRepository.findAll().stream().
                anyMatch(likes -> "likes-01".equals(likes.getId()) &&
                        "Artes".equals(likes.getName()) &&
                        "Pintura, lienzos, pinceles".equals(likes.getDescription())
                ));
    }

    @Test
    void testSetAndGet() {
        likes.setId("id-001");
        likes.setName("test");
        likes.setDescription("likes of test");

        assertEquals("id-001", likes.getId());
        assertEquals("test", likes.getName());
        assertEquals("likes of test", likes.getDescription());
    }

    @Test
    void testTreeLikesIfLeaf() {

        this.leaf1.add(null);
        this.leaf1.remove(null);
        assertFalse(this.leaf1.isComposite());
        assertFalse(this.leaf12.isComposite());
        assertFalse(this.leaf21.isComposite());
    }

    @Test
    void testTreeLikesIfComposite() {
        assertTrue(this.root.isComposite());
        assertTrue(this.sub1.isComposite());
        assertTrue(this.sub2.isComposite());
    }

    @Test
    void testTreeLikesNameAndId() {
        assertEquals("id1", this.leaf1.id());
        assertEquals("name1", this.leaf1.likesEntityName());

        assertEquals("sub1", this.sub1.id());
        assertEquals("subn1", this.sub1.likesEntityName());
    }


    @Test
    void testTreeLikesCompositeAddAndRemove() {
        LikesEntity auxLikesEntity = new LikesEntity("idT1", "nameT1", "descriptionT1");
        TreeLikesEntity leafT = new TreeLikesEntityLeaf(auxLikesEntity);
        this.sub1.add(leafT);
        assertEquals(3, this.sub1.treeLikesEntityList().size());

        this.sub1.remove(leafT);
        assertEquals(2, this.sub1.treeLikesEntityList().size());
    }


}
