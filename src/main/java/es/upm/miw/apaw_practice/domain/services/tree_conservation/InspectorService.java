package es.upm.miw.apaw_practice.domain.services.tree_conservation;

import es.upm.miw.apaw_practice.domain.models.tree_conservation.Inspector;
import es.upm.miw.apaw_practice.domain.models.tree_conservation.InspectorName;
import es.upm.miw.apaw_practice.domain.persistence_ports.tree_conservation.InspectorPersistence;
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
