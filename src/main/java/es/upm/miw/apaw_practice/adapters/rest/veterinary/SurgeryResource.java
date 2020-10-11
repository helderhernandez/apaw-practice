package es.upm.miw.apaw_practice.adapters.rest.veterinary;

import es.upm.miw.apaw_practice.domain.services.veterinary.SurgeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SurgeryResource.SURGERIES)
public class SurgeryResource {

    static final String SURGERIES = "/shop/surgeries";

    static final String ID = "/{id}";
    static final String ANIMALS = "/animals";
    static final String VETERINARIES = "/veterinaries";

    private SurgeryService surgeryService;

    @Autowired
    public SurgeryResource(SurgeryService surgeryService) {
        this.surgeryService = surgeryService;
    }


}
