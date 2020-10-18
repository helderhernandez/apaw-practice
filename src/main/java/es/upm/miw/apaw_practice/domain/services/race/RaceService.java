package es.upm.miw.apaw_practice.domain.services.race;

import es.upm.miw.apaw_practice.adapters.rest.race.LocationDto;
import es.upm.miw.apaw_practice.domain.models.race.Race;
import es.upm.miw.apaw_practice.domain.persistence_ports.race.RacePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    private RacePersistence racePersistence;

    @Autowired
    public RaceService(RacePersistence racePersistence) {
        this.racePersistence = racePersistence;
    }

    public Race updateLocation(String id, LocationDto locationDto) {
        return racePersistence.updateLocation(id, locationDto.getLocation());
    }

    public void deleteSectionByOrder(String raceId, String sectionOrder) {
        racePersistence.deleteSectionByOrder(raceId, sectionOrder);
    }
}
