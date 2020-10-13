package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrendPositionUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialTrendPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialTrendService {

    private SocialTrendPersistance socialTrendPersistance;

    @Autowired
    public SocialTrendService(SocialTrendPersistance socialTrendPersistance) {
        this.socialTrendPersistance = socialTrendPersistance;
    }

    public void updatePositions(List<SocialTrendPositionUpdating> socialTrendPositionUpdatingList) {
        socialTrendPositionUpdatingList.stream()
                .map(socialTrendNewPosition -> {
                    SocialTrend socialTrend = this.socialTrendPersistance.readById(socialTrendNewPosition.getId());
                    socialTrend.setPosition(socialTrendNewPosition.getPosition());
                    return socialTrend;
                })
                .forEach(socialTrend -> this.socialTrendPersistance.update(socialTrend));
    }

}
