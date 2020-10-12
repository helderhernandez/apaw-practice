package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUser;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialUserCreation;
import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SocialUserResource.USERS)
public class SocialUserResource {

    static final String USERS = "/socialnetwork/users";

    private SocialUserService socialUserService;

    @Autowired
    public SocialUserResource(SocialUserService socialUserService) {
        this.socialUserService = socialUserService;
    }

    @PostMapping
    public SocialUser create(@RequestBody SocialUserCreation socialUserCreation) {
        return this.socialUserService.create(socialUserCreation);
    }

}
