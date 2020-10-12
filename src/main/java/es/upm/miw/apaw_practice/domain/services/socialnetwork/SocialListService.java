package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialListPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialListService {

    private SocialListPersistance socialListPersistance;

    @Autowired
    public SocialListService(SocialListPersistance socialListPersistance) {
        this.socialListPersistance = socialListPersistance;
    }

    public void delete(String id) {
        this.socialListPersistance.deleteById(id);
    }

}
