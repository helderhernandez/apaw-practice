package es.upm.miw.apaw_practice.adapters.rest.sportyrental;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.sportyRental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.services.sportyRental.DiscountSportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.stream.Stream;

@RestController
@RequestMapping(DiscountSportyResource.DISCOUNTS_SPORTY)
public class DiscountSportyResource {

    static final String DISCOUNTS_SPORTY = "/sportyRental/discounts";
    static final String ID_DISCOUNT = "/{idDiscount}";
    static final String SEARCH_DISCOUNT_DESCRIPTIONS = "/searchDiscountDescriptions";

    private DiscountSportyService discountSportyService;

    @Autowired
    public DiscountSportyResource(DiscountSportyService discountSportyService) {
        this.discountSportyService = discountSportyService;
    }

    @PatchMapping(path = ID_DISCOUNT)
    public DiscountSporty updateDescription(@PathVariable String idDiscount, @RequestBody Double percentage) {
        return this.discountSportyService.updateDescription(idDiscount, percentage);
    }

    @GetMapping(SEARCH_DISCOUNT_DESCRIPTIONS)
    public Stream<String> readDescriptionsDiscountByNumMaxPersonGreaterThan(@RequestParam String q) {
        BigDecimal numMaxPerson = new LexicalAnalyzer().extractWithAssure(q, "numMaxPerson", BigDecimal::new);
        return this.discountSportyService.readDescriptionsDiscountByNumMaxPersonGreaterThan(numMaxPerson.intValue());
    }
}
