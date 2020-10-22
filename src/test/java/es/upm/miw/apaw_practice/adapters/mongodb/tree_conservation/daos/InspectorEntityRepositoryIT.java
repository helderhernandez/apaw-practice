package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.InspectorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class InspectorEntityRepositoryIT {
    @Autowired
    private InspectorRepository inspectorRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.inspectorRepository.findByDni("dni4").isEmpty());
        assertTrue(this.inspectorRepository.findByDni("dni1").isPresent());
        InspectorEntity inspector = this.inspectorRepository.findByDni("dni1").get();
        InspectorEntity inspector1 = this.inspectorRepository.findAll().stream()
                .filter(inspectorEntity -> "dni1".equals(inspectorEntity.getDni()))
                .findFirst().get();
        assertEquals(inspector1.getFirstName(), inspector.getFirstName());
        assertEquals(inspector1.getLastName(), inspector.getLastName());
        assertEquals(inspector1.getAge(), inspector.getAge());
        assertEquals(inspector1.getEmail(), inspector.getEmail());
        assertEquals(inspector1.getPhoneNumber(), inspector.getPhoneNumber());
        assertEquals(inspector1.getId(), inspector.getId());
        assertEquals(inspector1.getDni(), inspector.getDni());
        assertEquals(inspector1.hashCode(), inspector.hashCode());
        assertEquals(inspector1.toString(), inspector.toString());
        assertEquals(inspector1, inspector);
    }

    @Test
    void testEquals() {
        InspectorEntity inspector = this.inspectorRepository.findAll().get(0);
        assertTrue(this.inspectorRepository.findAll().stream()
                .anyMatch(inspector::equals));
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
