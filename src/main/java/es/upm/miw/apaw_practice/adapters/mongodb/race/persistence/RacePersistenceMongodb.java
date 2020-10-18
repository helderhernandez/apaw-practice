package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.SectionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.Race;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RacePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("racePersistence")
public class RacePersistenceMongodb implements RacePersistence {

    private RaceRepository raceRepository;

    @Autowired
    public RacePersistenceMongodb(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    @Override
    public Race readById(String id) {
        return raceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Race ID: + id"))
                .toRace();
    }

    @Override
    public Race updateLocation(String id, String location) {
        RaceEntity raceEntity = raceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Race ID: " + id));
        raceEntity.setLocation(location);
        return raceRepository.save(raceEntity).toRace();
    }

    @Override
    public void deleteSectionByOrder(String raceId, String sectionOrder) {
        RaceEntity raceEntity = raceRepository.findById(raceId)
                .orElseThrow(() -> new NotFoundException("Race ID: " + raceId));
        List<SectionEntity> sectionEntities = raceEntity.getSectionEntities();
        sectionEntities = sectionEntities
                .stream()
                .filter(sectionEntity -> !sectionEntity.getOrder().equals(Integer.valueOf(sectionOrder)))
                .collect(Collectors.toList());
        raceEntity.setSectionEntities(sectionEntities);
        raceRepository.save(raceEntity);
    }

    @Override
    public List<Race> findByName(String raceName) {
        List<RaceEntity> raceEntities = raceRepository.findByName(raceName);
        return raceEntities.stream()
                .map(RaceEntity::toRace)
                .collect(Collectors.toList());
    }

    @Override
    public List<Race> findAllByRunnerDni(String dni) {
        return raceRepository.findAll()
                .stream()
                .filter(race -> race.getRunnerEntities()
                        .stream()
                        .anyMatch(runner -> runner.getDni().equals(dni)))
                .map(RaceEntity::toRace)
                .collect(Collectors.toList());
    }

}
