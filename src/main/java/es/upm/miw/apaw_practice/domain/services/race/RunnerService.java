package es.upm.miw.apaw_practice.domain.services.race;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnerService {

    private RunnerPersistence runnerPersistence;

    @Autowired
    public RunnerService(RunnerPersistence runnerPersistence) {
        this.runnerPersistence = runnerPersistence;
    }

    public Runner readById(String id) {
        return runnerPersistence.readById(id);
    }

}
