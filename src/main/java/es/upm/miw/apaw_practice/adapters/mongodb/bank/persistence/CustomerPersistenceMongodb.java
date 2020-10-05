package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.CustomerPersistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("customerPersistence")
public class CustomerPersistenceMongodb implements CustomerPersistance {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerPersistenceMongodb(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Stream<Customer> readAll() {
        return this.customerRepository.findAll().stream()
                .map(CustomerEntity::toCustomer);
    }

    public Customer create(CustomerCreation customerCreation) {
        this.assertDniNotExist(customerCreation.getDNI());
        return this.customerRepository
                .save(new CustomerEntity(customerCreation))
                .toCustomer();

    }

    public void assertDniNotExist(String DNI) {
        this.customerRepository
                .findByDNI(DNI)
                .ifPresent(customer -> {
                    throw new ConflictException("DNI already exists: " + DNI);
                });
    }

}
