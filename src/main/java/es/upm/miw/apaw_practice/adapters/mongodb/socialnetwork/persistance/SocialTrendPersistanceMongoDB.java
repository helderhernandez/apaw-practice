package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialTrendRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialTrendEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialTrendPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("socialTrendPersistance")
public class SocialTrendPersistanceMongoDB implements SocialTrendPersistance {

    private SocialTrendRepository socialTrendRepository;

    @Autowired
    public SocialTrendPersistanceMongoDB(SocialTrendRepository socialTrendRepository) {
        this.socialTrendRepository = socialTrendRepository;
    }

    @Override
    public SocialTrend readById(String id) {
        return this.socialTrendRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("SocialTrend id: " + id))
                .toSocialTrend();
    }

    @Override
    public SocialTrend update(SocialTrend socialTrend) {
        SocialTrendEntity socialTrendEntity = this.socialTrendRepository.findById(socialTrend.getId())
                .orElseThrow(() -> new NotFoundException("SocialTrend id: " + socialTrend.getId()));
        socialTrendEntity.fromSocialTrend(socialTrend);
        return this.socialTrendRepository.save(socialTrendEntity).toSocialTrend();
    }

}
