package es.upm.miw.apaw_practice.adapters.mongodb.garage.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.garage.entities.MechanicEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MechanicEntityRepositoryIT {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Test
    void testFindByDepartment() {
        assertTrue(this.mechanicRepository.findByDepartment("Tapicería").isPresent());
        List<MechanicEntity> mechanics = this.mechanicRepository.findByDepartment("Tapicería").get();
        assertTrue(!mechanics.isEmpty());
        assertEquals("Andrea Montaño", mechanics.get(0).getName());
        assertEquals("111222333", mechanics.get(0).getTelephone());
        assertEquals(0, BigDecimal.valueOf(10.50).compareTo(mechanics.get(0).getPricePerHour()));
        assertEquals(0, Double.valueOf(7.50).compareTo(mechanics.get(0).getNumWorkedHours()));
        assertEquals(Boolean.TRUE, mechanics.get(0).getAvailable());
    }

}
