package es.upm.miw.apaw_practice.domain.services.race;

import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerClubPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RunnerClubService {

    private RunnerClubPersistence runnerClubPersistence;

    @Autowired
    public RunnerClubService(RunnerClubPersistence runnerClubPersistence) {
        this.runnerClubPersistence = runnerClubPersistence;
    }

    public RunnerClub create(RunnerClubCreation runnerClubCreation) {
        return this.runnerClubPersistence.create(runnerClubCreation);
    }
}
