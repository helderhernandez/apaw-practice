package es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.AdCampaign;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface AdCampaignPersistence {
    Stream<AdCampaign> readAll();
}
