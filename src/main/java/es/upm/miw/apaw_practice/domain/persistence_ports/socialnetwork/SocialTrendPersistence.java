package es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface SocialTrendPersistence {

    SocialTrend readById(String id);

    SocialTrend update(SocialTrend socialTrend);

    Stream<SocialTrend> readByName(String trendName);

}
