package es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.CustomerTarget;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerTargetPersistence {
    CustomerTarget updateName(String id, String name);

    void deleteById(String id);
}
