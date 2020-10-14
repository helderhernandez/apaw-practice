package es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.daos.CustomerSportyRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportyRental.entities.CustomerSportyEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportyRental.CustomerSporty;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental.CustomerSportyPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("customerSportyPersistence")
public class CustomerSportyPersistenceMongodb implements CustomerSportyPersistence {

    private CustomerSportyRepository customerSportyRepository;

    @Autowired
    public CustomerSportyPersistenceMongodb(CustomerSportyRepository customerSportyRepository) {
        this.customerSportyRepository = customerSportyRepository;
    }

    @Override
    public Stream<CustomerSporty> readAll() {
        return this.customerSportyRepository.findAll().stream().map(CustomerSportyEntity::convertToCustomerSporty);
    }

    @Override
    public void deleteByDni(String dni) {
        CustomerSportyEntity customerSportyEntity = this.customerSportyRepository.findByDni(dni)
                .orElseThrow(() -> new NotFoundException("CustomerSporty dni: " + dni));
        this.customerSportyRepository.delete(customerSportyEntity);
    }
}
