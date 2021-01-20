package es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface LikesPersistence {
    Likes create(Likes like);

    Stream<Likes> findByPromotionTitle(String title);
}
