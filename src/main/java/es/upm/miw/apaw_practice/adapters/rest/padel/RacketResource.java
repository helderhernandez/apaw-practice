package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.domain.models.padel.RacketPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.padel.RacketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RacketResource.RACKETS)
public class RacketResource {
    static final String RACKETS ="/padel/rackets";
    static final String ID_ID = "/{id}";

    private RacketService racketService;

    public RacketResource(RacketService racketService) {
        this.racketService = racketService;
    }

    @PatchMapping
    public void updatePrices(@RequestBody RacketPriceUpdating racketPriceUpdating) {
        this.racketService.uptadePrices(racketPriceUpdating);
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id){
        this.racketService.delete(id);
    }
}
