package es.upm.miw.apaw_practice.adapters.mongodb.transport.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.DepartmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.ExtraRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.daos.WorkerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.ExtraEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.transport.entities.WorkerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.persistence_ports.transport.ExtraPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("extraPersistence")
public class ExtraPersistenceMongodb implements ExtraPersistence {

    private ExtraRepository extraRepository;
    private DepartmentRepository departmentRepository;
    private WorkerRepository workerRepository;

    @Autowired
    public ExtraPersistenceMongodb(ExtraRepository extraRepository, DepartmentRepository departmentRepository, WorkerRepository workerRepository) {
        this.extraRepository = extraRepository;
        this.departmentRepository = departmentRepository;
        this.workerRepository = workerRepository;
    }

    @Override
    public Extra update(Extra extra) {
        ExtraEntity extraEntity = this.extraRepository
                .findById(extra.getId())
                .orElseThrow(() -> new NotFoundException("Extra id: " + extra.getId()));
        extraEntity.fromStudent(extra);
        return this.extraRepository
                .save(extraEntity)
                .toExtra();
    }

    @Override
    public Extra findById(String id) {
        return this.extraRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("ShoppingCart id:" + id))
                .toExtra();
    }

    @Override
    public Stream<Extra> readAll() {
        return this.extraRepository.findAll().stream()
                .map(ExtraEntity::toExtra);    }

    @Override
    public void deleteById(String id) {
        this.extraRepository.deleteById(id);
    }

    @Override
    public Stream<Integer> readWorkedHoursByDepartment(String name) {
        List<String> ListofWorkers = this.departmentRepository.findByName(name)
                .orElseThrow(() ->new NotFoundException("Department named " + name + " not found"))
                .getWorkerEntityList().stream()
                .map(WorkerEntity::toWorker)
                .map(Worker::getDni)
                .collect(Collectors.toList());
        return this.workerRepository.findAll().stream()
                .filter(worker -> ListofWorkers.contains(worker.getDni()))
                .map(WorkerEntity::getExtraEntities)
                .flatMap(Collection::stream)
                .map(ExtraEntity::toExtra)
                .map(Extra::getWorkedHours);
    }
}
