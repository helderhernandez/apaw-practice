package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.DurationsUpdating;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.services.sportcentre.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(SpecialityResource.SPECIALITIES)
public class SpecialityResource {

    static final String SPECIALITIES = "/sportcentre/specialities";

    private SpecialityService specialityService;

    @Autowired
    public SpecialityResource(SpecialityService specialityService){
        this.specialityService = specialityService;
    }

    @GetMapping
    public Stream<Speciality> readAll(){
        return this.specialityService.readAll();
    }

    @PatchMapping
    public void updateDurations(@RequestBody List<DurationsUpdating> listDurations){
        this.specialityService.updateDurations(listDurations);
    }

}
