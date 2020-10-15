package es.upm.miw.apaw_practice.domain.persistence_ports.sportyRental;

import es.upm.miw.apaw_practice.domain.models.sportyRental.CustomerSporty;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface CustomerSportyPersistence {

    Stream<CustomerSporty> readAll();

    void deleteByDni(String dni);

    Stream<String> readDescriptionsCategoryByCustomerName(String name);
}
