package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectorEntity;
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
        assertEquals(27, inspector.getAge());
        assertEquals("email1", inspector.getEmail());
        assertEquals("phone1", inspector.getPhoneNumber());
    }

    @Test
    void testInspectorBuilder() {
        InspectorEntity inspector = InspectorEntity.builder()
                .dni("dniTestBuilder")
                .firstName("firstNameTestBuilder")
                .lastName("lastNameTestBuilder")
                .age(20)
                .email("emailTestBuilder")
                .phoneNumber("phoneTestBuilder")
                .build();
        assertEquals("dniTestBuilder", inspector.getDni());
        assertEquals("firstNameTestBuilder", inspector.getFirstName());
        assertEquals("lastNameTestBuilder", inspector.getLastName());
        assertEquals(20, inspector.getAge());
        assertEquals("emailTestBuilder", inspector.getEmail());
        assertEquals("phoneTestBuilder", inspector.getPhoneNumber());
    }
}
