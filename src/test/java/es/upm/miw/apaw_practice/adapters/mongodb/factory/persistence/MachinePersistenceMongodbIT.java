package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class MachinePersistenceMongodbIT {

    @Autowired
    private MachinePersistenceMongodb machinePersistence;

    @Autowired
    private FactorySeederService factorySeederService;

    @Autowired
    private MachineRepository machineRepository;

    @Test
    void testUpdateStatus() {
        MachineEntity machine = this.machineRepository
                .findBySerialNumber(900600L)
                .get();
        assertNotNull(machine.getId());
        this.machinePersistence.updateStatus(machine.getId(), true);
        Boolean active = this.machineRepository.findBySerialNumber(900600L).get().getActive();
        assertTrue(active);
        this.machinePersistence.updateStatus(machine.getId(), false);
    }

    @Test
    void testFindMachineByEmployeeDegreeTitle() {
        Stream<Machine> machines = this.machinePersistence.findMachineByEmployeeDegreeTitle("Grado en Ingenieria de Telecomunicaciones");
        List<Machine> machineList = machines.collect(Collectors.toList());

        assertEquals(900600, machineList.get(0).getSerialNumber());
        assertEquals("00000000A", machineList.get(0).getEmployeeEntities().get(0).getDni());
        assertEquals("Cob", machineList.get(0).getEmployeeEntities().get(1).getLastName());

        assertEquals(800500, machineList.get(1).getSerialNumber());
        assertEquals(666666664L, machineList.get(1).getEmployeeEntities().get(1).getPhone());
    }

    @Test
    void testEmployeeByDegree() {
        List<String> employeesDni = this.machinePersistence.employeeByDegree("Grado en Ingenieria de Telecomunicaciones");
        assertEquals(List.of("00000000A", "11111111B", "44444444E", "55555555F"), employeesDni);
    }


}

