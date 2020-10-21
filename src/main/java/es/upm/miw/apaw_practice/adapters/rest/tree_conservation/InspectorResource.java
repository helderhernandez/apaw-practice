package es.upm.miw.apaw_practice.adapters.rest.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.InspectorName;
import es.upm.miw.apaw_practice.domain.services.tree_conservation.InspectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(InspectorResource.INSPECTORS)
public class InspectorResource {

    static final String INSPECTORS = "/tree-conservation/inspectors";

    private final InspectorService inspectorService;

    @Autowired
    public InspectorResource(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @PatchMapping
    public Inspector updateName(@RequestBody InspectorName inspectorName) {
        return this.inspectorService.updateName(inspectorName);
    }
}
