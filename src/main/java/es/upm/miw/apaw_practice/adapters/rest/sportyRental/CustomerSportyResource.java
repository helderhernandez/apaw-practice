package es.upm.miw.apaw_practice.adapters.rest.sportyRental;

import es.upm.miw.apaw_practice.domain.services.sportyRental.CustomerSportyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CustomerSportyResource.CUSTOMERS_SPORTY)
public class CustomerSportyResource {

    static final String CUSTOMERS_SPORTY = "/sportyRental/customers";
    static final String DNI_CUSTOMER = "/{dni}";

    private CustomerSportyService customerSportyService;

    @Autowired
    public CustomerSportyResource(CustomerSportyService customerSportyService) {
        this.customerSportyService = customerSportyService;
    }

    @DeleteMapping(path = DNI_CUSTOMER)
    public void deleteByDni(@PathVariable String dni) {
        this.customerSportyService.deleteByDni(dni);
    }
}
