package es.upm.miw.apaw_practice.adapters.rest.tree_conservation;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.Disease;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.DiseaseCreation;
import es.upm.miw.apaw_practice.domain.services.tree_conservation.DiseaseService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(DiseaseResource.DISEASES)
public class DiseaseResource {
    static final String DISEASES = "/tree-conservation/diseases";
    static final String NAME_ID = "/{name}";
    static final String SEARCH = "/search";

    private final DiseaseService diseaseService;

    public DiseaseResource(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @PostMapping
    public Disease create(@RequestBody DiseaseCreation diseaseCreation) {
        return this.diseaseService.create(diseaseCreation);
    }

    @DeleteMapping(NAME_ID)
    public void delete(@PathVariable String name) {
        this.diseaseService.delete(name);
    }

    @GetMapping(SEARCH)
    public Stream<DiseaseNameDto> findByInspectionType(@RequestParam String q) {
        String type = new LexicalAnalyzer().extractWithAssure(q, "type", String::new);
        return this.diseaseService.findByInspectionType(type).map(DiseaseNameDto::new).distinct();
    }
}
