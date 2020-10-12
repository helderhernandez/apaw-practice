package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.DiscountSporty;
import es.upm.miw.apaw_practice.domain.services.sportyRental.DiscountSportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(DiscountSportyResource.DISCOUNTS_SPORTY)
public class DiscountSportyResource {

    static final String DISCOUNTS_SPORTY = "/sportyRental/discounts";
    static final String ID_DISCOUNT = "/{idDiscount}";

    private DiscountSportyService discountSportyService;

    @Autowired
    public DiscountSportyResource(DiscountSportyService discountSportyService) {
        this.discountSportyService = discountSportyService;
    }

    @PatchMapping
    @PutMapping(path = ID_DISCOUNT)
    public DiscountSporty updateDescription(@PathVariable String idDiscount, @RequestBody Double percentage) {
        return this.discountSportyService.updateDescription(idDiscount, percentage);
    }
}
