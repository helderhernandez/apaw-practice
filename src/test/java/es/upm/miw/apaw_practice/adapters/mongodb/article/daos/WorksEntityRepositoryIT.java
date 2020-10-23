package es.upm.miw.apaw_practice.adapters.mongodb.article.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite.TreeWorks;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite.TreeWorksComposite;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.composite.TreeWorksLeaf;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class WorksEntityRepositoryIT {

    @Autowired
    private WorksRepository worksRepository;


    private TreeWorks rootWorks;
    private TreeWorks subLevelWorks1;
    private TreeWorks subLevelWorks2;
    private TreeWorks leafWorks1;
    private TreeWorks leafWorks2;
    private TreeWorks leafWorks3;
    private TreeWorks leafWorks4;
    private TreeWorks leafWorks5;

    @BeforeEach
    void init() {
        this.rootWorks = new TreeWorksComposite();
        this.subLevelWorks1 = new TreeWorksComposite();
        this.subLevelWorks2 = new TreeWorksComposite();

        this.leafWorks1 = new TreeWorksLeaf(this.worksRepository.findAll().get(0));
        this.leafWorks2 = new TreeWorksLeaf(this.worksRepository.findAll().get(1));
        this.leafWorks3 = new TreeWorksLeaf(this.worksRepository.findAll().get(2));
        this.leafWorks4 = new TreeWorksLeaf(this.worksRepository.findAll().get(3));
        this.leafWorks5 = new TreeWorksLeaf(this.worksRepository.findAll().get(4));

        this.rootWorks.add(this.subLevelWorks1);
        this.subLevelWorks1.add(leafWorks1);
        this.subLevelWorks1.add(leafWorks2);
        this.rootWorks.add(this.leafWorks2);
        this.subLevelWorks2.add(leafWorks3);
        this.subLevelWorks2.add(leafWorks4);
        this.subLevelWorks2.add(leafWorks5);
    }

    @Test
    void testFindByIsm() {

        assertTrue(this.worksRepository.findByIsmn((long)45848798).isPresent());
        WorksEntity works = this.worksRepository.findByIsmn((long)45848798).get();
        assertEquals("Journey to the West", works.getName());
        assertEquals((long)45848798, works.getIsmn());
        assertEquals(LocalDate.of(2013,7,26), works.getPublicationDate());
        assertEquals("masterpiece", works.getDescription());
        assertEquals(new BigDecimal("15.99"), works.getPrice());
        assertEquals((byte) 5, works.getGrade());

    }

    @Test
    void entityCreationTest(){
        WorksEntity entity = new WorksEntity();
        entity.setName("Cnn");
        entity.setIsmn((long)68746541);
        entity.setPublicationDate(LocalDate.of(2013,11,26));
        entity.setDescription("Amazing");
        entity.setPrice(new BigDecimal("11.99"));
        entity.setGrade((byte) 2);
        assertEquals("Cnn", entity.getName());
        assertEquals((long)68746541, entity.getIsmn());
        assertEquals(LocalDate.of(2013,11,26), entity.getPublicationDate());
        assertEquals("Amazing", entity.getDescription());
        assertEquals(new BigDecimal("11.99"), entity.getPrice());
        assertEquals((byte) 2, entity.getGrade());

    }

    @Test
    void testWorksesLeaves() {
        assertEquals(1, this.leafWorks1.numberOfDescendants());
        assertFalse(this.leafWorks1.isComposite());
        assertThrows(UnsupportedOperationException.class, () -> this.leafWorks1.add(new TreeWorksLeaf(this.worksRepository.findAll().get(4))));
    }

    @Test
    void testTreeProductComposite() {
        assertTrue(this.rootWorks.isComposite());
        assertTrue(this.subLevelWorks1.isComposite());
        assertTrue(this.subLevelWorks2.isComposite());
    }
}
