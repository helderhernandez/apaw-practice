package es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PromotionPersistence {
    Promotion update(Promotion update);

    Promotion readById(String id);

    Stream<Promotion> findByAdCampaignWithLikeName(String likeName);
}
