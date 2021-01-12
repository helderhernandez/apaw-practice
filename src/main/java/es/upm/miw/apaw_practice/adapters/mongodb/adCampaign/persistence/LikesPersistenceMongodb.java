package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.LikesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.LikesPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("LikesPersistence")
public class LikesPersistenceMongodb implements LikesPersistence {

    private LikesRepository likesRepository;

    @Autowired
    public LikesPersistenceMongodb(LikesRepository likesRepository) {
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
}
