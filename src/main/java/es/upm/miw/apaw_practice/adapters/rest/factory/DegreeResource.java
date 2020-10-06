package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.domain.services.factory.DegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DegreeResource.DEGREES)
public class DegreeResource {

    static final String DEGREES = "/factory/degrees";
    static final String ID_ID = "/{id}";

    private DegreeService degreeService;

    @Autowired
    public DegreeResource(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.degreeService.delete(id);
    }
}
