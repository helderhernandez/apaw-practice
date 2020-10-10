package es.upm.miw.apaw_practice.adapters.mongodb.race;

import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RunnerClubRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RunnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerClubEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.SectionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RaceSeederService {

    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private RunnerRepository runnerRepository;
    @Autowired
    private RunnerClubRepository runnerClubRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Race Inital Load -----------");
        RunnerClubEntity[] runnerClubEntities = {
                new RunnerClubEntity("1", "Runners Club", "Madrid", LocalDateTime.of(2008, 1, 10, 0, 0)),
                new RunnerClubEntity("2", "BCN Runners Club", "Barcelona", LocalDateTime.of(2015, 4, 1, 0, 0))
        };
        runnerClubRepository.saveAll(List.of(runnerClubEntities));
        RunnerEntity[] runnerEntities = {
                new RunnerEntity("1", "Juan", "00000001", 1, Boolean.TRUE, runnerClubEntities[0]),
                new RunnerEntity("2", "Maria", "00000002", 2, Boolean.TRUE, runnerClubEntities[0]),
                new RunnerEntity("3", "Jose", "00000003", 3, Boolean.FALSE, runnerClubEntities[1]),
                new RunnerEntity("4", "Silvia", "00000004", 4, Boolean.FALSE, runnerClubEntities[1]),

        };
        runnerRepository.saveAll(List.of(runnerEntities));
        SectionEntity[] sectionEntities = {
                new SectionEntity(1, 2800),
                new SectionEntity(2, 3200),
                new SectionEntity(3, 4000),
                new SectionEntity( 1, 3500),
                new SectionEntity( 2, 4000),
                new SectionEntity( 3, 2500),
        };
        RaceEntity[] raceEntities = {
                new RaceEntity("1", "Madrid Running Race", "Madrid", LocalDateTime.of(2019, 10, 1, 0, 0), new BigDecimal("3000"), List.of(sectionEntities[0], sectionEntities[1], sectionEntities[2]), List.of(runnerEntities[0], runnerEntities[1])),
                new RaceEntity("2", "Barcelona Running Race", "Barcelona", LocalDateTime.of(2018, 5, 10, 0, 0), new BigDecimal("4000"), List.of(sectionEntities[3], sectionEntities[4], sectionEntities[5]), List.of(runnerEntities[2], runnerEntities[3]))
        };
        raceRepository.saveAll(List.of(raceEntities));
    }

    public void deleteAll() {
        raceRepository.deleteAll();
        runnerRepository.deleteAll();
        runnerClubRepository.deleteAll();
    }
}
