package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import es.upm.miw.apaw_practice.domain.services.studio.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DesignResource.DESIGN)
public class DesignResource {

    static final String DESIGN = "/studio/designs";

    private DesignService designService;

    @Autowired
    public DesignResource(DesignService designService) {
        this.designService = designService;
    }

    @PostMapping
    public Design create(@RequestBody DesignCreation designCreation) {
        return this.designService.create(designCreation);
    }
}
