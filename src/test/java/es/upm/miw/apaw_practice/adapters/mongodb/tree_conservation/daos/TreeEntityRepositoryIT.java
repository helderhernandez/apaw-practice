package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.TreeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TreeEntityRepositoryIT {
    @Autowired
    private TreeRepository treeRepository;

    @Test
    void testFindById() {
        assertTrue(this.treeRepository.findById("fakeId").isEmpty());
        TreeEntity treeTest = this.treeRepository.findAll().get(0);
        String idTest = treeTest.getId();
        assertTrue(this.treeRepository.findById(idTest).isPresent());
        TreeEntity treeTest1 = this.treeRepository.findById(idTest).get();
        assertEquals(treeTest1.getId(), treeTest.getId());
        assertEquals(treeTest1.getAge(), treeTest.getAge());
        assertEquals(treeTest1.getMonitored(), treeTest.getMonitored());
        assertEquals(treeTest1.getRegistrationDate(), treeTest.getRegistrationDate());
        assertEquals(treeTest1.getSpecie(), treeTest.getSpecie());
        assertEquals(treeTest1.getDiseaseEntities(), treeTest.getDiseaseEntities());
        assertEquals(treeTest1.getInspectionEntities(), treeTest.getInspectionEntities());
        assertEquals(treeTest1.hashCode(), treeTest.hashCode());
        assertEquals(treeTest1.toString(), treeTest.toString());
        assertEquals(treeTest1, treeTest);
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.treeRepository.findAll().stream()
                .anyMatch(tree ->
                        "young".equals(tree.getAge()) &&
                                "specie1".equals(tree.getSpecie()) &&
                                tree.getRegistrationDate() != null &&
                                tree.getRegistrationDate().isBefore(LocalDateTime.now()) &&
                                !tree.getMonitored() &&
                                2 == tree.getDiseaseEntities().size() &&
                                "disease1".equals(tree.getDiseaseEntities().get(0).getName()) &&
                                "This is the disease1".equals(tree.getDiseaseEntities().get(0).getDescription()) &&
                                2 == tree.getInspectionEntities().size() &&
                                "type1".equals(tree.getInspectionEntities().get(0).getType()) &&
                                "status1".equals(tree.getInspectionEntities().get(0).getTreeStatus())
                ));
    }
}
