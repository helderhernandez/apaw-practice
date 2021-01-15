package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.adCampaign.Promotion;
import es.upm.miw.apaw_practice.domain.models.adCampaign.PromotionHeaderUpdating;
import es.upm.miw.apaw_practice.domain.services.adCampaign.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(PromotionResource.PROMOTIONS)
public class PromotionResource {
    static final String PROMOTIONS = "/ad-campaign/promotions";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";

    private PromotionService promotionService;

    @Autowired
    public PromotionResource(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @PatchMapping
    public void updateHeaders(@RequestBody List<PromotionHeaderUpdating> promotionHeaderUpdatingList) {
        promotionService.updateHeaders(promotionHeaderUpdatingList);
    }

    @GetMapping(ID_ID)
    public Promotion updateDescription(@PathVariable String id) {
        return this.promotionService.readById(id);
    }

    @GetMapping(SEARCH)
    public Stream<Promotion> findByAdCampaignWithLikeName(@RequestParam String q) {
        String likeName = new LexicalAnalyzer().extractWithAssure(q, "like-name");
        return this.promotionService.findByAdCampaignWithLikeName(likeName);
    }

}
