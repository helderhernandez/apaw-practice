package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialTrendPersistance {

    SocialTrend readById(String id);

    SocialTrend update(SocialTrend socialTrend);

}
