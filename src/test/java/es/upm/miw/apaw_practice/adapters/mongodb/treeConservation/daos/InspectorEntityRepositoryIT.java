package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.InspectorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class InspectorEntityRepositoryIT {
    @Autowired
    private InspectorRepository inspectorRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.inspectorRepository.findByDni("dni4").isEmpty());
        assertTrue(this.inspectorRepository.findByDni("dni1").isPresent());
        InspectorEntity inspector = this.inspectorRepository.findByDni("dni1").get();
        assertEquals("firstName1", inspector.getFirstName());
        assertEquals("lastName1", inspector.getLastName());
        assertEquals("email1", inspector.getEmail());
        assertEquals("phone1", inspector.getPhoneNumber());
    }
}
