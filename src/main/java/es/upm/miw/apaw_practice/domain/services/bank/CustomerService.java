package es.upm.miw.apaw_practice.domain.services.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.CustomerPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CustomerService {

    private final CustomerPersistance customerPersistance;

    @Autowired
    public CustomerService(CustomerPersistance customerPersistance) {
        this.customerPersistance = customerPersistance;
    }

    public Stream<Customer> readAll() {
        return this.customerPersistance.readAll();
    }
}
