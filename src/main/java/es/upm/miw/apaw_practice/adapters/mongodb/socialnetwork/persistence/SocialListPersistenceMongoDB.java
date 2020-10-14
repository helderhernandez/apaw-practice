package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialListRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialListPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("socialListPersistence")
public class SocialListPersistenceMongoDB implements SocialListPersistence {

    private SocialListRepository socialListRepository;

    @Autowired
    public SocialListPersistenceMongoDB(SocialListRepository socialListRepository) {
        this.socialListRepository = socialListRepository;
    }

    @Override
    public void deleteById(String id) {
        this.socialListRepository.deleteById(id);
    }

}
