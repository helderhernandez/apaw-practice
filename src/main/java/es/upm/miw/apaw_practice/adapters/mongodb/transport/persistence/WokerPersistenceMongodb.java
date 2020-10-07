package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.WorkerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.WorkerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("workerPersistence")
public class WokerPersistenceMongodb implements WorkerPersistence {

    private WorkerRepository workerRepository;

    @Autowired
    public WokerPersistenceMongodb(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public Worker read(String dni) {
        return this.workerRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Dni: " + dni))
                .toWorker();
    }
}
