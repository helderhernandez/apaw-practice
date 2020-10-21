package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectionEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class InspectionEntityRepositoryIT {

    @Autowired
    private InspectionRepository inspectionRepository;

    @Test
    void testFindById() {
        assertTrue(this.inspectionRepository.findById("fakeId").isEmpty());
        InspectionEntity inspectionTest = this.inspectionRepository.findAll().get(0);
        String idTest = inspectionTest.getId();
        assertTrue(this.inspectionRepository.findById(idTest).isPresent());
        InspectionEntity inspectionTest1 = this.inspectionRepository.findById(idTest).get();
        assertEquals(inspectionTest1.getTreeStatus(), inspectionTest.getTreeStatus());
        assertEquals(inspectionTest1.getId(), inspectionTest.getId());
        assertEquals(inspectionTest1.getType(), inspectionTest.getType());
        assertEquals(inspectionTest1.getDate(), inspectionTest.getDate());
        assertEquals(inspectionTest1.getInspectorEntity(), inspectionTest.getInspectorEntity());
        assertEquals(inspectionTest1.hashCode(), inspectionTest.hashCode());
        assertEquals(inspectionTest1.toString(), inspectionTest.toString());
        assertTrue(inspectionTest.equals(inspectionTest1));
    }

    @Test
    void testCreateAndRead() {
        assertTrue(this.inspectionRepository.findAll().stream()
                .anyMatch(inspection ->
                        inspection.getDate() != null &&
                                inspection.getDate().isBefore(LocalDateTime.now()) &&
                                "type1".equals(inspection.getType()) &&
                                "status1".equals(inspection.getTreeStatus()) &&
                                "dni1".equals(inspection.getInspectorEntity().getDni()) &&
                                "firstName1".equals(inspection.getInspectorEntity().getFirstName()) &&
                                "lastName1".equals(inspection.getInspectorEntity().getLastName()) &&
                                27 == inspection.getInspectorEntity().getAge() &&
                                "email1".equals(inspection.getInspectorEntity().getEmail()) &&
                                "phone1".equals(inspection.getInspectorEntity().getPhoneNumber())
                ));
    }
}
