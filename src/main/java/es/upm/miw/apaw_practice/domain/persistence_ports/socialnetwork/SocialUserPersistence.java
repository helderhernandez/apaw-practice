package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SocialUserPersistence {

    SocialUser create(SocialUserCreation socialUserCreation);

    SocialUser updateBiography(String id, String biography);

    Stream<SocialUser> readAll();

}
