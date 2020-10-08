package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.models.factory.Employee;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import org.junit.jupiter.api.BeforeEach;
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
        List<Machine> machines = this.machinePersistence.findMachineByEmployeeDegreeTitle("Grado en Ingenieria de Telecomunicaciones");
        System.out.println(machines);

        // System.out.println(machines.get(0));
        // System.out.println(machines.get(1));
        // System.out.println(machines.get(0).getEmployeeEntities().get(0));
        // System.out.println(machines.get(0).getEmployeeEntities().get(1));
        //assertEquals("00000000A",machines.get(0).getEmployeeEntities().get(0).getDni());
        //assertEquals("Cob",machines.get(0).getEmployeeEntities().get(1).getLastName());
        //assertEquals(666666664L,machines.get(1).getEmployeeEntities().get(0).getPhone());
    }
    @Test
    void testEmployeesFromMachine() {
        MachineEntity machine0 = this.machineRepository
                .findBySerialNumber(900600L)
                .get();
        Stream<EmployeeEntity> employees0 = this.machinePersistence.employeesFromMachine(machine0.toMachine());

        MachineEntity machine1 = this.machineRepository
                .findBySerialNumber(800500L)
                .get();
        Stream<EmployeeEntity> employees1 = this.machinePersistence.employeesFromMachine(machine1.toMachine());

        MachineEntity machine2 = this.machineRepository
                .findBySerialNumber(700500L)
                .get();
        Stream<EmployeeEntity> employees2 = this.machinePersistence.employeesFromMachine(machine2.toMachine());
    }

    @Test
    void testFilterMachinesWithEmployees() {
        Machine machine0 = this.machineRepository
                .findBySerialNumber(900600L)
                .get()
                .toMachine();

        Machine machine1 = this.machineRepository
                .findBySerialNumber(800500L)
                .get()
                .toMachine();

        Machine machine2 = this.machineRepository
                .findBySerialNumber(700500L)
                .get()
                .toMachine();
        List<String> employees = this.machinePersistence.employeeByDegree("Grado en Ingenieria de Telecomunicaciones");
        Stream<Machine> machineStream = Stream.of(machine0, machine1, machine2);
        //System.out.println("Machines before: >>>> " + machineStream.collect(Collectors.toList()));
        //Stream<Machine> machines = this.machinePersistence.filterMachinesWithEmployees(machineStream,employees);
        //machines.forEach(System.out::println);
        //System.out.println("Machines with employees: >>>> " + machines.collect(Collectors.toList()));
    }

}

