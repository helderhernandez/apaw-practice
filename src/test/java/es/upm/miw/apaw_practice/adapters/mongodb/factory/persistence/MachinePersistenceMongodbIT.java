package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        List<Machine> x = this.machinePersistence.findMachineByEmployeeDegreeTitle("Grado en Ingeria de Telecomunicaciones");
        System.out.println(x);
    }
}

