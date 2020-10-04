package es.upm.miw.apaw_practice.domain.persistence_ports.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CustomerPersistance {
    Stream<Customer> readAll();
}
