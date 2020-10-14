package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.TreeConservationSeederService;
import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.treeConservation.InspectorName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class InspectorPersistenceMongodbIT {

    @Autowired
    private InspectorPersistenceMongodb inspectorPersistenceMongodb;

    @Autowired
    private TreeConservationSeederService treeConservationSeederService;

    @Test
    void testUpdate() {
        Optional<Inspector> inspectorTest = this.inspectorPersistenceMongodb.readAll()
                .filter(inspector -> "dni3".equals(inspector.getDni()))
                .findFirst();
        assertTrue(inspectorTest.isPresent());
        InspectorName inspectorNameTest = new InspectorName(inspectorTest.get());
        inspectorNameTest.setFirstName("firstNameTest");
        inspectorNameTest.setLastName("lastNameTest");
        this.inspectorPersistenceMongodb.updateName(inspectorNameTest);
        Optional<Inspector> newInspectorTest = this.inspectorPersistenceMongodb.readAll()
                .filter(inspector -> "dni3".equals(inspector.getDni()))
                .findFirst();
        assertTrue(newInspectorTest.isPresent());
        assertEquals(inspectorTest.get().getAge(), newInspectorTest.get().getAge());
        assertEquals(inspectorTest.get().getDni(), newInspectorTest.get().getDni());
        assertEquals(inspectorTest.get().getEmail(), newInspectorTest.get().getEmail());
        assertEquals("firstNameTest", newInspectorTest.get().getFirstName());
        assertEquals("lastNameTest", newInspectorTest.get().getLastName());
        treeConservationSeederService.deleteAll();
        treeConservationSeederService.seedDatabase();
    }
}
