package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerAssociatePersistence {

    CustomerAssociate updateName(String documentId, String name);

    CustomerAssociate readByDocumentId(String documentId);
}
