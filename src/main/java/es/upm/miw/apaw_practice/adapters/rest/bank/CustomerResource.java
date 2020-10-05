package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import es.upm.miw.apaw_practice.domain.services.bank.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(CustomerResource.CUSTOMERS)
public class CustomerResource {
    static final String CUSTOMERS = "/bank/customers";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";

    private final CustomerService customerService;

    @Autowired
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public Stream<Customer> readAll() {
        return this.customerService.readAll();
    }

    @PostMapping
    public Customer create(@RequestBody CustomerCreation customerCreation) {
        return this.customerService.create(customerCreation);
    }

}
