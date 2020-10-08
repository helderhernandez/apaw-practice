package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.MortgageRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.MortgagePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository("mortgagePersistence")
public class MortgagePersistenceMongodb implements MortgagePersistence {

    private final MortgageRepository mortgageRepository;

    private final CustomerRepository customerRepository;

    @Autowired
    public MortgagePersistenceMongodb(MortgageRepository mortgageRepository, CustomerRepository customerRepository) {
        this.mortgageRepository = mortgageRepository;
        this.customerRepository = customerRepository;
    }

    public List<String> findDNIbyCustomers() {
        return this.mortgageRepository.findAll().stream()
                .map(mortgage -> mortgage.getCustomerEntity().getDNI())
                .collect(Collectors.toList());
    }
}
