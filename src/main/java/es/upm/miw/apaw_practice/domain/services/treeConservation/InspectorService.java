package es.upm.miw.apaw_practice.domain.services.treeConservation;

import es.upm.miw.apaw_practice.domain.models.treeConservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.treeConservation.InspectorName;
import es.upm.miw.apaw_practice.domain.persistence_ports.treeConservation.InspectorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InspectorService {
    private final InspectorPersistence inspectorPersistence;

    @Autowired
    public InspectorService(InspectorPersistence inspectorPersistence) {
        this.inspectorPersistence = inspectorPersistence;
    }

    public Inspector updateName(InspectorName inspectorName) {
        return this.inspectorPersistence.updateName(inspectorName);
    }
}
