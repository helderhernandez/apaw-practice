package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrendPositionUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialTrendPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialTrendService {

    private SocialTrendPersistence socialTrendPersistence;

    @Autowired
    public SocialTrendService(SocialTrendPersistence socialTrendPersistence) {
        this.socialTrendPersistence = socialTrendPersistence;
    }

    public void updatePositions(List<SocialTrendPositionUpdating> socialTrendPositionUpdatingList) {
        socialTrendPositionUpdatingList.stream()
                .map(socialTrendNewPosition -> {
                    SocialTrend socialTrend = this.socialTrendPersistence.readById(socialTrendNewPosition.getId());
                    socialTrend.setPosition(socialTrendNewPosition.getPosition());
                    return socialTrend;
                })
                .forEach(socialTrend -> this.socialTrendPersistence.update(socialTrend));
    }

}
