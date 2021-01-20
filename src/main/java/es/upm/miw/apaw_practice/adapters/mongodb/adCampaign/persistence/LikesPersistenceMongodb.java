package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.AdCampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.LikesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.LikesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("LikesPersistence")
public class LikesPersistenceMongodb implements LikesPersistence {

    private LikesRepository likesRepository;

    private AdCampaignRepository adCampaignRepository;

    @Autowired
    public LikesPersistenceMongodb(LikesRepository likesRepository, AdCampaignRepository adCampaignRepository) {
        this.adCampaignRepository = adCampaignRepository;
        this.likesRepository = likesRepository;
    }

    public void assertIdNotExist(String id) {
        this.likesRepository.findById(id).ifPresent(likes -> {
            throw new ConflictException("Id exist: " + id);
        });
    }

    @Override
    public Likes create(Likes likes) {
        this.assertIdNotExist(likes.getId());
        return this.likesRepository
                .save(new LikesEntity(likes.getId(), likes.getName(), likes.getDescription()))
                .toLikes();
    }

    @Override
    public Stream<Likes> findByPromotionTitle(String title) {
        return this.adCampaignRepository.findAll()
                .stream().filter(adCampaignEntity ->
                        adCampaignEntity.getPromotionEntities().stream()
                                .anyMatch(promotionEntity -> promotionEntity.getTitle().equals(title)))
                .map(adCampaignEntity -> adCampaignEntity.getLikesEntity().toLikes());
    }
}
