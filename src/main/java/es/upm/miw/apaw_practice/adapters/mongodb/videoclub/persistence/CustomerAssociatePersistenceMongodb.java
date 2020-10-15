package es.upm.miw.apaw_practice.adapters.mongodb.videoclub.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.daos.CustomerAssociateRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videoclub.entities.CustomerAssociateEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videoclub.CustomerAssociate;
import es.upm.miw.apaw_practice.domain.persistence_ports.videoclub.CustomerAssociatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("customerAssociatePersistence")
public class CustomerAssociatePersistenceMongodb implements CustomerAssociatePersistence {

    private CustomerAssociateRepository customerAssociateRepository;

    @Autowired
    public CustomerAssociatePersistenceMongodb(CustomerAssociateRepository customerAssociateRepository) {
        this.customerAssociateRepository = customerAssociateRepository;
    }

    @Override
    public CustomerAssociate updateName(String documentId, String name) {
        CustomerAssociateEntity customerAssociateEntity = this.customerAssociateRepository
                .findByDocumentId(documentId)
                .orElseThrow(() -> new NotFoundException("Document_id: " + documentId));
        customerAssociateEntity
                .setName(name);
        return this.customerAssociateRepository
                .save(customerAssociateEntity)
                .toCustomerAssociate();
    }

    @Override
    public CustomerAssociate readByDocumentId(String documentId) {
        return this.customerAssociateRepository
                .findByDocumentId(documentId)
                .orElseThrow(() -> new NotFoundException("Document id: " + documentId))
                .toCustomerAssociate();
    }
}
