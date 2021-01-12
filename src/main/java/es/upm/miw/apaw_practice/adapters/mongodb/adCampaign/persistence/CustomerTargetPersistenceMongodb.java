package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.CustomerTargetRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.CustomerTargetEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.adCampaign.CustomerTarget;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.CustomerTargetPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("CustomerTargetPersistence")
public class CustomerTargetPersistenceMongodb implements CustomerTargetPersistence {

    private CustomerTargetRepository customerTargetRepository;

    @Autowired
    public CustomerTargetPersistenceMongodb(CustomerTargetRepository customerTargetRepository) {
        this.customerTargetRepository = customerTargetRepository;
    }

    @Override
    public CustomerTarget updateName(String id, String name) {
        CustomerTargetEntity customerTargetEntity = this.customerTargetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Customer Target id:" + id));
        customerTargetEntity.setName(name);
        return this.customerTargetRepository.save(customerTargetEntity).toCustomerTarget();
    }
}
