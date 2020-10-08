package es.upm.miw.apaw_practice.domain.services.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.WorkerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private WorkerPersistence workerPersistence;

    @Autowired
    public WorkerService(WorkerPersistence workerPersistence) {
        this.workerPersistence = workerPersistence;
    }

    public Worker read(String dni) {
        return this.workerPersistence.read(dni);
    }
}
