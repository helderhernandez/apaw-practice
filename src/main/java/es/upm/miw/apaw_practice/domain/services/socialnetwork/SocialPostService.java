package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence.SocialPostPersistenceMongoDB;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SocialPostService {

    private SocialPostPersistenceMongoDB socialPostPersistance;

    @Autowired
    public SocialPostService(SocialPostPersistenceMongoDB socialPostPersistance) {
        this.socialPostPersistance = socialPostPersistance;
    }

    public Stream<SocialPost> readAll() {
        return this.socialPostPersistance.readAll();
    }

    public void create(SocialPost socialPost) {
        this.socialPostPersistance.create(socialPost);
    }

}
