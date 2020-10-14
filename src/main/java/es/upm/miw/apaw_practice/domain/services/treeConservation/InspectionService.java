package es.upm.miw.apaw_practice.domain.services.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspection;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.InspectionPersistence;
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
