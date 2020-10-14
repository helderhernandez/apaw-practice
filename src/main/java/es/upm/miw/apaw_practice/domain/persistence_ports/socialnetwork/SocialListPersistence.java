package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SocialListPersistence {

    void deleteById(String id);

    Set<String> findVerifiedNickNamesByListName(String listName);

}
