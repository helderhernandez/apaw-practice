package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class TreeEntityRepositoryIT {
    @Autowired
    private TreeRepository treeRepository;

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
