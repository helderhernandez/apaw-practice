package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialUserPersistance {

    SocialUser create(SocialUserCreation socialUserCreation);

    SocialUser updateBiography(String id, String biography);

}
