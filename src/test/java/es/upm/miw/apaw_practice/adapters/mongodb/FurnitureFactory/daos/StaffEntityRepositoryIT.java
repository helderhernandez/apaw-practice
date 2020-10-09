package es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.FurnitureFactory.entities.StaffEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class StaffEntityRepositoryIT {

    @Autowired
    private StaffRepository staffRepository;
    @Test
    void testFindByDni() {
        assertTrue(this.staffRepository.findByDni("Y6687008C").isPresent());
        StaffEntity worker = this.staffRepository.findByDni("Y6687008C").get();
        assertEquals("Jose", worker.getFirstName());
        assertEquals("Luis", worker.getLastName());
        assertEquals(688010527, worker.getPhone());
        assertEquals("hamal", worker.getPost());
    }


}


