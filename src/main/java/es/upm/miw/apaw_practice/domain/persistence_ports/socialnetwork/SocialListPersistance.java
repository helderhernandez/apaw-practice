package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import org.springframework.stereotype.Repository;

@Repository
public interface SocialListPersistance {

    void deleteById(String id);

}
