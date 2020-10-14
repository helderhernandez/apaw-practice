package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RunnerClubRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerClubEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClub;
import es.upm.miw.apaw_practice.domain.models.race.RunnerClubCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RunnerClubPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("runnerClubPersistence")
public class RunnerClubPersistenceMongodb implements RunnerClubPersistence {

    private RunnerClubRepository runnerClubRepository;

    @Autowired
    public RunnerClubPersistenceMongodb(RunnerClubRepository runnerClubRepository) {
        this.runnerClubRepository = runnerClubRepository;
    }

    @Override
    public RunnerClub findByName(String name) {
        return this.runnerClubRepository
                .findByName(name)
                .orElseThrow(() -> new NotFoundException("Runner club name: " + name))
                .toRunnerClub();
    }

    @Override
    public RunnerClub create(RunnerClubCreation runnerClubCreation) {
        return runnerClubRepository.save(new RunnerClubEntity(runnerClubCreation)).toRunnerClub();
    }
}
