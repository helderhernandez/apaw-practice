package es.upm.miw.apaw_practice.adapters.mongodb.transport.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class WorkerEntityRepositoryIT {

    @Autowired
    private WorkerRepository workerRepository;

    @Test
    void testRead() {
        assertTrue(this.workerRepository.findByDni("dni2").isPresent());
        WorkerEntity worker = this.workerRepository.findByDni("dni2").get();
        assertEquals("name2", worker.getName());
        assertEquals("telephone2", worker.getTelephone());
        assertEquals(worker.getExtraEntities().get(0).getWorkedHours(), 3);
        assertTrue(worker.getExtraEntities().get(0).getPaid());
    }
}
