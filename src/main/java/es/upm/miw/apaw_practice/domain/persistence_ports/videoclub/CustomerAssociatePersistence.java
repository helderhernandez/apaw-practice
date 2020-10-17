package es.upm.miw.apaw_practice.domain.persistence_ports.videoclub;

import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CustomerAssociatePersistence {

    CustomerAssociate updateName(String documentId, String name);

    CustomerAssociate readByDocumentId(String documentId);

    void deleteByDocumentId(String documentId);

    Stream<CustomerAssociate> readAll();
}
