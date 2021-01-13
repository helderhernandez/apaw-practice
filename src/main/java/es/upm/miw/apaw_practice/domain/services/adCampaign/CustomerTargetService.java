package es.upm.miw.apaw_practice.domain.services.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.CustomerTarget;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.CustomerTargetPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerTargetService {

    private CustomerTargetPersistence customerTargetPersistence;

    @Autowired
    public CustomerTargetService(CustomerTargetPersistence customerTargetPersistence) {
        this.customerTargetPersistence = customerTargetPersistence;
    }

    public CustomerTarget updateName(String id, String name) {
        return customerTargetPersistence.updateName(id, name);
    }

    public void delete(String id) {
        customerTargetPersistence.deleteById(id);
    }
}
