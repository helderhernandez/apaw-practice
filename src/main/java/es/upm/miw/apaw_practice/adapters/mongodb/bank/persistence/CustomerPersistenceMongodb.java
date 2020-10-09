package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.bank.CustomerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.CustomerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("customerPersistence")
public class CustomerPersistenceMongodb implements CustomerPersistence {

    private final CustomerRepository customerRepository;

    private final MortgagePersistenceMongodb mortgagePersistence;

    private final SharedAccountPersistenceMongodb sharedAccountPersistence;

    @Autowired
    public CustomerPersistenceMongodb(CustomerRepository customerRepository, MortgagePersistenceMongodb mortgagePersistence, SharedAccountPersistenceMongodb sharedAccountPersistence) {
        this.customerRepository = customerRepository;
        this.mortgagePersistence = mortgagePersistence;
        this.sharedAccountPersistence = sharedAccountPersistence;
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

    public List<String> findDNIByMortgageAndSharedAccount() {
        List<String> shared = this.sharedAccountPersistence.findDNIBySharedAccount();
        List<String> mortgages = this.mortgagePersistence.findDNIbyCustomers();
        return shared.stream()
                .distinct()
                .filter(mortgages::contains)
                .collect(Collectors.toList());

    }

}
