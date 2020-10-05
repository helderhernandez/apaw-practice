package es.upm.miw.apaw_practice.domain.services.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CustomerService {

    private final CustomerPersistence customerPersistence;

    @Autowired
    public CustomerService(CustomerPersistence customerPersistence) {
        this.customerPersistence = customerPersistence;
    }

    public Stream<Customer> readAll() {
        return this.customerPersistence.readAll();
    }

    public Customer create(CustomerCreation customerCreation) {
        return this.customerPersistence.create(customerCreation);
    }
}
