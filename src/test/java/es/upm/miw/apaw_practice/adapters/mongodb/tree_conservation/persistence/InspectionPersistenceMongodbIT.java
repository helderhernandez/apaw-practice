package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.TreeConservationSeederService;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class InspectionPersistenceMongodbIT {

    @Autowired
    private InspectionPersistenceMongodb inspectionPersistenceMongodb;

    @Autowired
    private TreeConservationSeederService treeConservationSeederService;

    @Test
    void testUpdate() {
        Optional<Inspection> inspectionTest = this.inspectionPersistenceMongodb.readAll()
                .filter(inspection -> "type2".equals(inspection.getType()) &&
                        "status1".equals(inspection.getTreeStatus()))
                .findFirst();
        assertTrue(inspectionTest.isPresent());
        this.inspectionPersistenceMongodb.updateTreeStatus(inspectionTest.get().getId(), "statusTest");
        Optional<Inspection> newInspectionTest = this.inspectionPersistenceMongodb.readAll()
                .filter(inspection -> "statusTest".equals(inspection.getTreeStatus()))
                .findFirst();
        assertTrue(newInspectionTest.isPresent());
        assertEquals(inspectionTest.get().getDate(), newInspectionTest.get().getDate());
        assertEquals("type2", newInspectionTest.get().getType());
        assertEquals("statusTest", newInspectionTest.get().getTreeStatus());
        treeConservationSeederService.deleteAll();
        treeConservationSeederService.seedDatabase();
    }
}
