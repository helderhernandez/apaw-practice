package es.upm.miw.apaw_practice.domain.services.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspection;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.InspectionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectionService {
    private final InspectionPersistence inspectionPersistence;

    @Autowired
    public InspectionService(InspectionPersistence inspectionPersistence) {
        this.inspectionPersistence = inspectionPersistence;
    }

    public Inspection updateTreeStatus(String id, String treeStatus) {
        return this.inspectionPersistence.updateTreeStatus(id, treeStatus);
    }

}
