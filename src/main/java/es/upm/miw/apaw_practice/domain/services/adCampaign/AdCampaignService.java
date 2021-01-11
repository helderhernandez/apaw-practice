package es.upm.miw.apaw_practice.domain.services.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.AdCampaign;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.AdCampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AdCampaignService {

    private AdCampaignPersistence adCampaignPersistence;

    @Autowired
    public AdCampaignService(AdCampaignPersistence adCampaignPersistence) {
        this.adCampaignPersistence = adCampaignPersistence;
    }

    public Stream<AdCampaign> readAll() {
        return adCampaignPersistence.readAll();
    }
}
