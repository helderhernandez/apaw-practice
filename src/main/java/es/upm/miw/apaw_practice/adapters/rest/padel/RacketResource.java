package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.padel.RacketService;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RacketResource.RACKETS)
public class RacketResource {
    static final String RACKETS ="/padel/rackets";

    private RacketService racketService;

    public RacketResource(RacketService racketService) {
        this.racketService = racketService;
    }

    @PatchMapping
    public void updatePrices(@RequestBody RacketPriceUpdating racketPriceUpdating) {
        this.racketService.uptadePrices(racketPriceUpdating);
    }
}
