package es.upm.miw.apaw_practice.adapters.rest.car_dealership;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.car_dealership.CDOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(CDOwnerResource.OWNERS)
public class CDOwnerResource {
    static final String OWNERS = "/car-dealership/owners";
    static final String SEARCH = "/search";

    private CDOwnerService cdOwnerService;

    @Autowired
    public CDOwnerResource(CDOwnerService cdOwnerService) {
        this.cdOwnerService = cdOwnerService;
    }

    @GetMapping(SEARCH)
    public Stream<String> findOwnerByBrand(@RequestParam String q) {
        String brand = new LexicalAnalyzer().extractWithAssure(q, "brand");
        return this.cdOwnerService.findOwnerByBrand(brand);
    }
}
