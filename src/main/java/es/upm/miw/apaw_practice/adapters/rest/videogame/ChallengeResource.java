package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
import es.upm.miw.apaw_practice.domain.models.videogame.ChallengeDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.services.videogame.ChallengeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(ChallengeResource.CHALLENGES)
public class ChallengeResource {

    static final String CHALLENGES = "/videogame/challenges";
    static final String SEARCH = "/search";


    private ChallengeService challengeService;

    @Autowired

    public ChallengeResource(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    @PatchMapping
    public void updateDescription(@RequestBody List<ChallengeDescriptionUpdating> challengeDescriptionUpdatingList) {
        this.challengeService.updateDescription(challengeDescriptionUpdatingList);
    }

    @GetMapping(SEARCH)
    public Stream <Challenge> findCompletedChallengesByDescription(@RequestParam String q){
        String description = new LexicalAnalyzer().extractWithAssure(q,"description");
        return this.challengeService.findCompletedChallengesByDescription(description);
    }



}
