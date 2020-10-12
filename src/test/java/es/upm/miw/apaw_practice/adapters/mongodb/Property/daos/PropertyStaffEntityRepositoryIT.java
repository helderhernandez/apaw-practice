package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyStaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class PropertyStaffEntityRepositoryIT {

    @Autowired
    private PropertyStaffRepository propertyStaffRepository;

    @Test
    void testFindById() {
        assertTrue(this.propertyStaffRepository.findById("2").isPresent());
        PropertyStaffEntity staff = this.propertyStaffRepository.findById("2").get();
        assertEquals("Eli", staff.getName());
        assertEquals("95720562E", staff.getDni());
        assertEquals("Wednesday on duty", staff.getDescription());
    }
}
