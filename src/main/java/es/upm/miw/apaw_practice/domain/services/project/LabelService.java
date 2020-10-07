package es.upm.miw.apaw_practice.domain.services.project;

import es.upm.miw.apaw_practice.domain.models.project.Label;
import es.upm.miw.apaw_practice.domain.persistence_ports.project.LabelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabelService {

    private LabelPersistence labelPersistence;

    @Autowired
    public LabelService(LabelPersistence labelPersistence) {
        this.labelPersistence = labelPersistence;
    }

    public Label create(Label label) {
        return this.labelPersistence.create(label);
    }

}
