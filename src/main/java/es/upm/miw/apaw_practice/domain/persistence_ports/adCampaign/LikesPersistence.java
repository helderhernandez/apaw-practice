package es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesPersistence {
    Likes create(Likes like);
}
