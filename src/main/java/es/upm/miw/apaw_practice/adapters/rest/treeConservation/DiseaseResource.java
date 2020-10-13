package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Disease;
import es.upm.miw.apaw_practice.domain.models.treeConservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.services.treeConservation.DiseaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DiseaseResource.DISEASES)
public class DiseaseResource {
    static final String DISEASES = "/tree-conservation/diseases";

    private final DiseaseService diseaseService;

    public DiseaseResource(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @PostMapping
    public Disease create(@RequestBody DiseaseCreation diseaseCreation) {
        return this.diseaseService.create(diseaseCreation);
    }
}
