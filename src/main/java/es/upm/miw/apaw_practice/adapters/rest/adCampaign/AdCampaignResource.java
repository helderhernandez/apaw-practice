package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.services.adCampaign.AdCampaignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(AdCampaignResource.AD_CAMPAIGNS)
public class AdCampaignResource {
    static final String AD_CAMPAIGNS = "/ad-campaign/ad-campaigns";
    static final String SEARCH = "/search";

    private AdCampaignService adCampaignService;

    @Autowired
    public AdCampaignResource(AdCampaignService adCampaignService) {
        this.adCampaignService = adCampaignService;
    }

    @GetMapping
    public Stream<BasicAdCampaignDto> redAll() {
        return this.adCampaignService.readAll()
                .map(BasicAdCampaignDto::new);
    }

    @GetMapping(SEARCH)
    public Stream<IdDto> findIdByLikesFromCustomerName(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.adCampaignService.findIdByLikesFromCustomerName(name).map(IdDto::new);
    }
}
