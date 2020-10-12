package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.services.transittaxes.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(TaxResource.TAXES)
public class TaxResource {
    static final String TAXES = "/transittaxes/taxes";
    static final String SEARCH = "/search";

    private TaxService taxService;


    @Autowired
    public TaxResource(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public Tax create(@RequestBody Tax tax) {
        return this.taxService.create(tax);
    }

    @GetMapping(SEARCH)
    public Tax findPriceTotalTaxesByIdCar(@RequestParam String q) {
        String idCar = new LexicalAnalyzer().extractWithAssure(q, "idCar");
        return this.taxService.findPriceTotalTaxesByIdCar(idCar);
    }
}
