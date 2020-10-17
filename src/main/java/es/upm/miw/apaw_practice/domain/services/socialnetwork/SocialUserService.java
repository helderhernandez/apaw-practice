package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrend;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialTrendPersistence;
import es.upm.miw.apaw_practice.domain.persistence_ports.socialnetwork.SocialUserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialUserService {

    private SocialUserPersistence socialUserPersistence;
    private SocialTrendPersistence socialTrendPersistence;

    @Autowired
    public SocialUserService(SocialUserPersistence socialUserPersistence, SocialTrendPersistence socialTrendPersistence) {
        this.socialUserPersistence = socialUserPersistence;
        this.socialTrendPersistence = socialTrendPersistence;
    }

    public SocialUser create(SocialUserCreation socialUserCreation) {
        return this.socialUserPersistence.create(socialUserCreation);
    }

    public SocialUser updateBiography(String id, String biography) {
        return this.socialUserPersistence.updateBiography(id, biography);
    }

    public List<String> findNickNamesByTrendName(String trendName) {
        return this.socialTrendPersistence.readByName(trendName)
                .map(SocialTrend::getSocialPostId)
                .map(this::findUserBySocialPostId)
                .map(SocialUser::getNickName)
                .collect(Collectors.toList());
    }

    public SocialUser findUserBySocialPostId(String socialPostId) {
        return this.socialUserPersistence.readAll()
                .filter(socialUser -> socialUser.getSocialPostIds().contains(socialPostId))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("SocialPostId " + socialPostId + " not related with any SocialUser"));
    }

}
