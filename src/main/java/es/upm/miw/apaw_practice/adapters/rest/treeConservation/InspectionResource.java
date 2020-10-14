package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspection;
import es.upm.miw.apaw_practice.domain.services.treeConservation.InspectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(InspectionResource.INSPECTIONS)
public class InspectionResource {
    static final String INSPECTIONS = "/tree-conservation/inspections";
    static final String ID_ID = "/{id}";
    static final String TREE_STATUS = "/tree-status";

    private final InspectionService inspectionService;

    @Autowired
    public InspectionResource(InspectionService inspectionService) {
        this.inspectionService = inspectionService;
    }

    @PutMapping(ID_ID + TREE_STATUS)
    public Inspection updateTreeStatus(@PathVariable String id, @RequestBody TreeStatusDto treeStatusDto) {
        return this.inspectionService.updateTreeStatus(id, treeStatusDto.getTreeStatus());
    }

}
