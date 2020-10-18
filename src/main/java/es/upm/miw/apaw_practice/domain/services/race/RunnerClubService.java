package es.upm.miw.apaw_practice.domain.services.race;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RacePersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerClubPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class RunnerClubService {

    private RunnerClubPersistence runnerClubPersistence;
    private RacePersistence racePersistence;

    @Autowired
    public RunnerClubService(RunnerClubPersistence runnerClubPersistence, RacePersistence racePersistence) {
        this.runnerClubPersistence = runnerClubPersistence;
        this.racePersistence = racePersistence;
    }

    public RunnerClub create(RunnerClubCreation runnerClubCreation) {
        return this.runnerClubPersistence.create(runnerClubCreation);
    }

    public Stream<String> findRunnerClubNameWithProfessionalRunnersByRaceName(String raceName) {
        return racePersistence.findByName(raceName).stream()
                .flatMap(race -> race.getRunners().stream())
                .filter(Runner::getProfessional)
                .map(Runner::getRunnerClub)
                .map(RunnerClub::getName)
                .distinct();
    }
}
