package es.upm.miw.apaw_practice.adapters.rest.race;

import es.upm.miw.apaw_practice.domain.models.race.Race;
import es.upm.miw.apaw_practice.domain.services.race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(RaceResource.RACES)
public class RaceResource {

    static final String RACES = "/race/races";
    static final String ID_ID = "/{id}";
    static final String SECTIONS = "/sections";
    static final String ORDER = "/{order}";

    private RaceService raceService;

    @Autowired
    public RaceResource(RaceService raceService) {
        this.raceService = raceService;
    }

    @PutMapping(ID_ID)
    public Race updateLocation(@PathVariable String id, @RequestBody LocationDto locationDto) {
        return this.raceService.updateLocation(id, locationDto);
    }

    @DeleteMapping(ID_ID + SECTIONS + ORDER)
    public void deleteSectionByOrder(@PathVariable("id") String raceId, @PathVariable("order") String sectionOrder) {
        this.raceService.deleteSectionByOrder(raceId, sectionOrder);
    }

}
