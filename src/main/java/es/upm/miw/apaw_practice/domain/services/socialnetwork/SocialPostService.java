package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistance.SocialPostPersistanceMongoDB;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SocialPostService {

    private SocialPostPersistanceMongoDB socialPostPersistance;

    @Autowired
    public SocialPostService(SocialPostPersistanceMongoDB socialPostPersistance) {
        this.socialPostPersistance = socialPostPersistance;
    }

    public Stream<SocialPost> readAll() {
        return this.socialPostPersistance.readAll();
    }

}
