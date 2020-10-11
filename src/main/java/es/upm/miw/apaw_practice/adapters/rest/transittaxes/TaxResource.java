package es.upm.miw.apaw_practice.adapters.rest.transittaxes;

import es.upm.miw.apaw_practice.domain.models.transittaxes.Tax;
import es.upm.miw.apaw_practice.domain.services.transittaxes.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TaxResource.TAXES)
public class TaxResource {
    static final String TAXES = "/transittaxes/taxes";
    private TaxService taxService;

    @Autowired
    public TaxResource(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping
    public Tax create(@RequestBody Tax tax){
        return this.taxService.create(tax);
    }

}
