package es.upm.miw.apaw_practice.domain.services.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.DesignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DesignService {

    private final DesignPersistence designPersistence;

    @Autowired
    public DesignService(DesignPersistence designPersistence) {
        this.designPersistence = designPersistence;
    }

    public Design create(DesignCreation designCreation) {
        return this.designPersistence.create(designCreation);
    }
}
