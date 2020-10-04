package es.upm.miw.apaw_practice.adapters.mongodb.factory.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.persistence_ports.factory.MachinePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("machinePersistence")
public class MachinePersistenceMongodb implements MachinePersistence {
    private MachineRepository machineRepository;

    @Autowired
    public MachinePersistenceMongodb(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine updateStatus(String id, Boolean isActive) {
        MachineEntity machineEntity = this.machineRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Machine id: " + id));
        machineEntity.setActive(isActive);
        return this.machineRepository
                .save(machineEntity)
                .toMachine();
    }

    @Override
    public Stream<Machine> readAll() {
        return this.machineRepository.findAll().stream()
                .map(MachineEntity::toMachine);
    }
}
