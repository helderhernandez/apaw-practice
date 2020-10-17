package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.services.transittaxes.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(AccidentResource.ACCIDENTS)
public class AccidentResource {

    static final String ACCIDENTS = "/transittaxes/accidents";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private AccidentService accidentService;

    @Autowired
    public AccidentResource(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping(ID_ID)
    public Accident read(@PathVariable String id) {
        return this.accidentService.read(id);
    }

    @PatchMapping
    public Accident updatePlace(@RequestBody Accident accident) {
        return this.accidentService.updatePlace(accident);
    }

    @GetMapping(SEARCH)
    public Stream<Accident> findRefAccidentsByNameOwner(@RequestParam String q) {
        String nameOwnerCar = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.accidentService.findRefAccidentsByNameOwner(nameOwnerCar);
    }
}
