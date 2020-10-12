package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialTrendPositionUpdating;
import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialTrendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(SocialTrendResource.TRENDS)
public class SocialTrendResource {

    static final String TRENDS = "/socialnetwork/trends";

    private SocialTrendService socialTrendService;

    @Autowired
    public SocialTrendResource(SocialTrendService socialTrendService) {
        this.socialTrendService = socialTrendService;
    }

    @PatchMapping
    public void updatePositions(@RequestBody List<SocialTrendPositionUpdating> socialTrendPositionUpdatingList) {
        this.socialTrendService.updatePositions(socialTrendPositionUpdatingList);
    }

}
