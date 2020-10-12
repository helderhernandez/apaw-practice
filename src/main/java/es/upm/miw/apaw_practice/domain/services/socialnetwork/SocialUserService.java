package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialUserPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialUserService {

    private SocialUserPersistance socialUserPersistance;

    @Autowired
    public SocialUserService(SocialUserPersistance socialUserPersistance) {
        this.socialUserPersistance = socialUserPersistance;
    }

    public SocialUser create(SocialUserCreation socialUserCreation) {
        return this.socialUserPersistance.create(socialUserCreation);
    }

    public SocialUser updateBiography(String id, String biography) {
        return this.socialUserPersistance.updateBiography(id, biography);
    }

}
