package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.ChallengeDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.services.videogame.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ChallengeResource.CHALLENGES)
public class ChallengeResource {

    static final String CHALLENGES = "/videogame/challenges";


    private ChallengeService challengeService;

    @Autowired

    public ChallengeResource(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PatchMapping
    public void updateDescription(@RequestBody List<ChallengeDescriptionUpdating> challengeDescriptionUpdatingList) {
        this.challengeService.updateDescription(challengeDescriptionUpdatingList);
    }

}
