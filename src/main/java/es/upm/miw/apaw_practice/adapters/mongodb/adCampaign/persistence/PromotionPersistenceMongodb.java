package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.AdCampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.PromotionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.PromotionEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.PromotionPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("PromotionPersistence")
public class PromotionPersistenceMongodb implements PromotionPersistence {

    private PromotionRepository promotionRepository;
    private AdCampaignRepository adCampaignRepository;

    @Autowired
    public PromotionPersistenceMongodb(PromotionRepository promotionRepository, AdCampaignRepository adCampaignRepository) {
        this.promotionRepository = promotionRepository;
        this.adCampaignRepository = adCampaignRepository;
    }

    @Override
    public Promotion update(Promotion promotion) {
        PromotionEntity promotionEntity = this.promotionRepository.findById(promotion.getId())
                .orElseThrow(() -> new NotFoundException("Promotion id: " + promotion.getId()));
        promotionEntity.fromArticle(promotion);
        return this.promotionRepository.save(promotionEntity).toPromotion();
    }

    @Override
    public Promotion readById(String id) {
        return this.promotionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Promotion id: " + id))
                .toPromotion();
    }

    @Override
    public Stream<Promotion> findByAdCampaignWithLikeName(String likeName) {
        return this.adCampaignRepository
                .findAll()
                .stream()
                .filter(adCampaignEntity -> adCampaignEntity.getLikesEntity().getName().equals(likeName))
                .flatMap(adCampaignEntity -> adCampaignEntity.getPromotionEntities().stream())
                .map(PromotionEntity::toPromotion);
    }
}
