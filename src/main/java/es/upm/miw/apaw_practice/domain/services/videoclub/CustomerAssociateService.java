package es.upm.miw.apaw_practice.domain.services.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.CustomerAssociatePersistence;
import org.springframework.stereotype.Service;

@Service
public class CustomerAssociateService {

    private CustomerAssociatePersistence customerAssociatePersistence;

    public CustomerAssociateService(CustomerAssociatePersistence customerAssociatePersistence) {
        this.customerAssociatePersistence = customerAssociatePersistence;
    }

    public CustomerAssociate updateName(String documentId, String name) {
        return this.customerAssociatePersistence.updateName(documentId, name);
    }

    public CustomerAssociate readByDocumentId(String documentId) {
        return this.customerAssociatePersistence.readByDocumentId(documentId);
    }
}
