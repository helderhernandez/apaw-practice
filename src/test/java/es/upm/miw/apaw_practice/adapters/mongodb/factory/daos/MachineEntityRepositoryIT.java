package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class MachineEntityRepositoryIT {

    @Autowired
    private MachineRepository machineRepository;

    @Test
    void testFindBySerialNumber() {
        assertTrue(this.machineRepository.findBySerialNumber(800500L).isPresent());
        MachineEntity machine = this.machineRepository.findBySerialNumber(800500L).get();
        assertTrue(machine.isActive());
        assertEquals(LocalDate.of(2019, 11, 1), machine.getLastInspection());
    }

    @Test
    void testCreateAndRead() {
        //System.out.println(this.machineRepository.findAll());
        assertTrue(this.machineRepository.findAll().stream()
                .anyMatch(mach ->
                        900600L == mach.getSerialNumber() &&
                                mach.getId() != null &&
                                !mach.isActive() &&
                                LocalDate.of(2020, 7, 1).equals(mach.getLastInspection()) &&
                                "00000000A".equals(mach.getEmployeeEntities().get(0).getDni()) &&
                                666666661L == mach.getEmployeeEntities().get(1).getPhone() &&
                                20000001L == mach.getProductEntities().get(1).getSerialNumber() &&
                                new BigDecimal("2560.74").equals(mach.getProductEntities().get(2).getWholesalePrice())
                ));
    }
}
