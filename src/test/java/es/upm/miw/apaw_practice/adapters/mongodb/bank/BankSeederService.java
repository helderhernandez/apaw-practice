package es.upm.miw.apaw_practice.adapters.mongodb.bank;


import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.CustomerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class BankSeederService {

    @Autowired
    private CustomerRepository customerRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Bank Initial Load -----------");
        CustomerEntity[] customers = {
                new CustomerEntity("Ulises", "511511511L", "666777888", "ulises@email.com"),
                new CustomerEntity("Manuel", "511511777L", "666777999", "manuel@email.com"),
                new CustomerEntity("Jorge", "511511444M", "666777666", "mayoralcillo@email.com"),
                new CustomerEntity("Anabel", "511333511A", "666333888", "anabelen@email.com"),
                new CustomerEntity("Emma", "666511511J", "666777333", "emmatega@email.com"),
        };
        this.customerRepository.saveAll(Arrays.asList(customers));
    }

    public void deleteAll() {
        this.customerRepository.deleteAll();
    }
}
