package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.Likes;
import es.upm.miw.apaw_practice.domain.models.school.Teacher;
import es.upm.miw.apaw_practice.domain.services.adCampaign.AdCampaignService;
import es.upm.miw.apaw_practice.domain.services.adCampaign.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(LikesResource.LIKES)
public class LikesResource {
    static final String LIKES = "/ad-campaign/likes";

    private LikesService likeService;

    @Autowired
    public LikesResource(LikesService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public Likes create(@RequestBody Likes likes) {
        return this.likeService.create(likes);
    }
}
