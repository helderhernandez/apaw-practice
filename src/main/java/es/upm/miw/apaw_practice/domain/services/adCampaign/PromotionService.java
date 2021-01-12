package es.upm.miw.apaw_practice.domain.services.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.models.adCampaign.PromotionHeaderUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.PromotionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionService {

    private PromotionPersistence promotionPersistence;

    @Autowired
    public PromotionService(PromotionPersistence promotionPersistence) {
        this.promotionPersistence = promotionPersistence;
    }

    public void updateHeaders(List<PromotionHeaderUpdating> promotionHeaderUpdatingList) {
        promotionHeaderUpdatingList.stream()
                .map(promotionNewHeader -> {
                    Promotion promotion = this.promotionPersistence.readById(promotionNewHeader.getId());
                    promotion.setHeader(promotionNewHeader.getHeader());
                    return promotion;
                }).forEach(promotion -> this.promotionPersistence.update(promotion));
    }

    public Promotion readById(String id) {
        return promotionPersistence.readById(id);
    }
}
