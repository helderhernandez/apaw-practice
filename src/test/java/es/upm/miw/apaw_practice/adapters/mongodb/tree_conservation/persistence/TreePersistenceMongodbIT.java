package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Tree;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class TreePersistenceMongodbIT {
    @Autowired
    private TreePersistenceMongodb treePersistenceMongodb;

    @Test
    void testReadById() {
        Optional<Tree> treeTest = this.treePersistenceMongodb.readAll()
                .filter(tree -> "young".equals(tree.getAge()) &&
                        "specie1".equals(tree.getSpecie()))
                .findFirst();
        assertTrue(treeTest.isPresent());
        assertNotNull(treeTest.get().getId());
        assertNotNull(treeTest.get().getRegistrationDate());

    }
}
