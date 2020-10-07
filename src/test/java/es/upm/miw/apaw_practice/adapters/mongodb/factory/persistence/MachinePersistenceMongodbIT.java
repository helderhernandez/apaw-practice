package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.FactorySeederService;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        Boolean isActive = this.machineRepository.findBySerialNumber(900600L).get().isActive();
        assertTrue(isActive);
        this.machinePersistence.updateStatus(machine.getId(), false);
    }
}

