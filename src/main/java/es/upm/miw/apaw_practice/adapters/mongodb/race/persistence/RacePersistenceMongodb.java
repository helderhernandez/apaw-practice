package es.upm.miw.apaw_practice.adapters.mongodb.race.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.race.daos.RaceRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RaceEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.race.Race;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RacePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}
