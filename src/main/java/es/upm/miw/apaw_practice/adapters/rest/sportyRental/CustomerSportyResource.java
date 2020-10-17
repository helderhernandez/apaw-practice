package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.sportyRental.CustomerSportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(CustomerSportyResource.CUSTOMERS_SPORTY)
public class CustomerSportyResource {

    static final String CUSTOMERS_SPORTY = "/sportyRental/customers";
    static final String DNI_CUSTOMER = "/{dni}";
    static final String SEARCH_CATEGORY_DESCRIPTIONS = "/searchCategoryDescriptions";

    private CustomerSportyService customerSportyService;

    @Autowired
    public CustomerSportyResource(CustomerSportyService customerSportyService) {
        this.customerSportyService = customerSportyService;
    }

    @DeleteMapping(path = DNI_CUSTOMER)
    public void deleteByDni(@PathVariable String dni) {
        this.customerSportyService.deleteByDni(dni);
    }

    @GetMapping(SEARCH_CATEGORY_DESCRIPTIONS)
    public Stream<String> readDescriptionsDiscountByNumMaxPersonGreaterThan(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name", String::new);
        return this.customerSportyService.readDescriptionsCategoryByCustomerName(name);
    }
}
