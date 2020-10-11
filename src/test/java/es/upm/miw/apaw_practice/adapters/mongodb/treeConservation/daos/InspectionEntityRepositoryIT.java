package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class InspectionEntityRepositoryIT {

    @Autowired
    private InspectionRepository inspectionRepository;

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
                                "email1".equals(inspection.getInspectorEntity().getEmail()) &&
                                "phone1".equals(inspection.getInspectorEntity().getPhoneNumber())
                ));
    }
}
