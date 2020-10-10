package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RunnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("runnerPersistence")
public class RunnerPersistenceMongodb implements RunnerPersistence {

    private RunnerRepository runnerRepository;

    @Autowired
    public RunnerPersistenceMongodb(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    @Override
    public Runner readById(String id) {
        Optional<RunnerEntity> runnerEntityOptional = runnerRepository.findById(id);
        if (runnerEntityOptional.isEmpty()) {
            throw new NotFoundException("Runner ID: " + id);
        }
        return runnerEntityOptional.get().toRunner();
    }
}
