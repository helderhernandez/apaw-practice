package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.WorkerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.WorkerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("workerPersistence")
public class WokerPersistenceMongodb implements WorkerPersistence {

    private WorkerRepository workerRepository;
    private DepartmentRepository departmentRepository;

    @Autowired
    public WokerPersistenceMongodb(WorkerRepository workerRepository, DepartmentRepository departmentRepository) {
        this.workerRepository = workerRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Worker read(String dni) {
        return this.workerRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException("Dni: " + dni))
                .toWorker();
    }

    @Override
    public List<String> findByDepartmentName(String name) {
        return this.departmentRepository.findByName(name)
                .orElseThrow(() -> new NotFoundException("Department named " + name + " not found"))
                .getWorkerEntityList().stream()
                .map(WorkerEntity::toWorker)
                .map(Worker::getDni)
                .collect(Collectors.toList());
    }
}
