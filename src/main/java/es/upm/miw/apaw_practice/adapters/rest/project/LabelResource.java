package es.upm.miw.apaw_practice.adapters.rest.project;

import es.upm.miw.apaw_practice.domain.models.project.Label;
import es.upm.miw.apaw_practice.domain.services.project.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LabelResource.LABEL)
public class LabelResource {

    static final String LABEL = "/project/labels";

    private LabelService labelService;

    @Autowired
    public LabelResource(LabelService labelService) {
        this.labelService = labelService;
    }

    @PostMapping
    public Label create(@RequestBody Label label) {
        return this.labelService.create(label);
    }

}
