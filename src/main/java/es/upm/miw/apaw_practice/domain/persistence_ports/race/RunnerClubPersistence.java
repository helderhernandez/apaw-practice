package es.upm.miw.apaw_practice.domain.persistence_ports.race;

import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface RunnerClubPersistence {

    RunnerClub findByName(String name);

    RunnerClub create(RunnerClubCreation runnerClubCreation);

}
