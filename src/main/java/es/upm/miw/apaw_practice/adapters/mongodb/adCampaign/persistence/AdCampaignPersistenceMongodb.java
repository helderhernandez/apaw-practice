package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.AdCampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.AdCampaignEntity;
import es.upm.miw.apaw_practice.domain.models.adCampaign.AdCampaign;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.AdCampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("AdCampaignPersistence")
public class AdCampaignPersistenceMongodb implements AdCampaignPersistence {

    private AdCampaignRepository adCampaignRepository;

    @Autowired
    public AdCampaignPersistenceMongodb(AdCampaignRepository adCampaignRepository) {
        this.adCampaignRepository = adCampaignRepository;
    }

    @Override
    public Stream<AdCampaign> readAll() {
        return adCampaignRepository.findAll().stream()
                .map(AdCampaignEntity::toAdCampaign);
    }
}
