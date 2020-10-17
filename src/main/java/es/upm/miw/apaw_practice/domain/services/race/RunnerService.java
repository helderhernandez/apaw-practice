package es.upm.miw.apaw_practice.domain.services.race;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.models.race.RunnerProfessionalUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public void updateProfessional(List<RunnerProfessionalUpdating> runnerProfessionalUpdatingList) {
        runnerProfessionalUpdatingList.stream()
                .map(runnerProfessionalUpdating -> {
                    Runner runner = runnerPersistence.readByDni(runnerProfessionalUpdating.getDni());
                    runner.setProfessional(runnerProfessionalUpdating.getProfessional());

                    return runner;
                })
                .forEach(runner -> runnerPersistence.update(runner));
    }
}
