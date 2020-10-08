package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Accident;
import es.upm.miw.apaw_practice.domain.services.transittaxes.AccidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccidentResource.ACCIDENT)
public class AccidentResource {

    static final String ACCIDENT = "/transittaxes/accidents";
    static final String ID_ID = "/{id}";

    private AccidentService accidentService;

    @Autowired
    public AccidentResource(AccidentService accidentService) {
        this.accidentService = accidentService;
    }

    @GetMapping(ID_ID)
    public Accident read(@PathVariable String id) {
        return this.accidentService.read(id);
    }
}
