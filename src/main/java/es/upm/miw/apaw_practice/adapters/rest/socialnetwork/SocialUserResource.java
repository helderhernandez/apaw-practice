package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(SocialUserResource.USERS)
public class SocialUserResource {

    static final String USERS = "/socialnetwork/users";
    static final String ID = "/{id}";
    static final String BIOGRAPHY = "/biography";
    static final String SEARCH = "/search";

    private SocialUserService socialUserService;

    @Autowired
    public SocialUserResource(SocialUserService socialUserService) {
        this.socialUserService = socialUserService;
    }

    @PostMapping
    public SocialUser create(@RequestBody SocialUserCreation socialUserCreation) {
        return this.socialUserService.create(socialUserCreation);
    }

    @PutMapping(ID + BIOGRAPHY)
    public SocialUser updateBiography(@PathVariable String id, @RequestBody BiographyDto biographyDto) {
        return this.socialUserService.updateBiography(id, biographyDto.getBiography());
    }

    @GetMapping(SEARCH)
    public List<String> findNickNamesByTrendName(@RequestParam String q) {
        String trendName = new LexicalAnalyzer().extractWithAssure(q, "trendName");
        return this.socialUserService.findNickNamesByTrendName(trendName);
    }

}
