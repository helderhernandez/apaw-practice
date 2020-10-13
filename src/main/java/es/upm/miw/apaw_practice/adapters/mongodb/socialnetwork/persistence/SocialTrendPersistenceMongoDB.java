package es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialPostRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.daos.SocialTrendRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialPostEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.socialnetwork.entities.SocialTrendEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialTrendPersistence;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("socialTrendPersistence")
public class SocialTrendPersistenceMongoDB implements SocialTrendPersistence {

    private SocialTrendRepository socialTrendRepository;
    private SocialPostRepository socialPostRepository;

    @Autowired
    public SocialTrendPersistenceMongoDB(SocialTrendRepository socialTrendRepository, SocialPostRepository socialPostRepository) {
        this.socialTrendRepository = socialTrendRepository;
        this.socialPostRepository = socialPostRepository;
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
        SocialPostEntity socialPostEntity = this.socialPostRepository.findById(socialTrend.getSocialPostId())
                .orElseThrow(() -> new NotFoundException("SocialPost id: " + socialTrend.getSocialPostId()));
        socialTrendEntity.fromSocialTrend(socialTrend, socialPostEntity);
        return this.socialTrendRepository.save(socialTrendEntity).toSocialTrend();
    }

    @Override
    public Stream<SocialTrend> readByName(String trendName) {
        return this.socialTrendRepository.findAll().stream()
                .filter(socialTrendEntity -> socialTrendEntity.getName().equals(trendName))
                .map(SocialTrendEntity::toSocialTrend);
    }

}
