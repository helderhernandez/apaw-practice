package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialPostRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialPostEntity;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialPostPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("socialPostPersistance")
public class SocialPostPersistanceMongoDB implements SocialPostPersistance {

    private SocialPostRepository socialPostRepository;

    @Autowired
    public SocialPostPersistanceMongoDB(SocialPostRepository socialPostRepository) {
        this.socialPostRepository = socialPostRepository;
    }

    @Override
    public Stream<SocialPost> readAll() {
        return this.socialPostRepository.findAll().stream().map(SocialPostEntity::toSocialPost);
    }

}
