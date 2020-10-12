package es.upm.miw.apaw_practice.adapters.mongodb.Property.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.property.daos.PropertyStaffRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.PropertyStaffEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.property.entities.ProprietorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class PropertyStaffEntityRepositoryIT {

    @Autowired
    private PropertyStaffRepository propertyStaffRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.propertyStaffRepository.findByDni("95720562E").isPresent());
        PropertyStaffEntity staff = this.propertyStaffRepository.findByDni("95720562E").get();
        assertEquals("Eli", staff.getName());
        assertEquals("Wednesday on duty", staff.getDescription());

    }
}
