package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.MortgageRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.SharedAccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("customerPersistence")
public class CustomerPersistenceMongodb implements CustomerPersistence {

    private final CustomerRepository customerRepository;

    private final MortgageRepository mortgageRepository;

    private final SharedAccountRepository sharedAccountRepository;

    @Autowired
    public CustomerPersistenceMongodb(CustomerRepository customerRepository, MortgageRepository mortgageRepository, SharedAccountRepository sharedAccountRepository) {
        this.customerRepository = customerRepository;
        this.mortgageRepository = mortgageRepository;
        this.sharedAccountRepository = sharedAccountRepository;
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

    public Stream<String> findDNIByMortgageAndSharedAccount() {
        Stream<String> DNIs = this.readAll()
                .map(item -> item.getDNI());


        return null;
    }

}
