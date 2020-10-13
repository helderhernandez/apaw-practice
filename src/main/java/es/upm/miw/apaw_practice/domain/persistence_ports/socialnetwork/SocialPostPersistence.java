package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SocialPostPersistence {

    Stream<SocialPost> readAll();

}
