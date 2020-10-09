package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.AdCampaignEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface AdCampaignRepository extends MongoRepository<AdCampaignEntity, String> {
    Optional <AdCampaignEntity> findByScheduleDate(LocalDateTime localDateTime);
}
