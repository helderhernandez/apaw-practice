package es.upm.miw.apaw_practice.adapters.mongodb.factory;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.EmployeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.ProductEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Service
public class FactorySeederService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Factory Initial Load -----------");

        ProductEntity[] products = {
                new ProductEntity("P0000", 1L, new BigDecimal("15.90")),
                new ProductEntity("P0001", 10000001L, new BigDecimal("7.40")),
                new ProductEntity("P0002", 20000001L, new BigDecimal("9.85")),
                new ProductEntity("P0003", 30000001L, new BigDecimal("106.65")),
                new ProductEntity("P0004", 40000001L, new BigDecimal("2560.74"))
        };
        this.productRepository.saveAll(Arrays.asList(products));

        EmployeeEntity[] employees = {
                new EmployeeEntity("00000000A", "Andrea", "Calvo", 666666660L,
                        LocalDate.of(2020, 9, 29), new BigDecimal("25000"), "Software"),
                new EmployeeEntity("11111111B", "Carlos", "Cob", 666666661L,
                        LocalDate.of(2019, 8, 28), new BigDecimal("26000"), "Hardware"),
                new EmployeeEntity("22222222C", "Carlos ", "Boyero", 666666662L,
                        LocalDate.of(2018, 7, 27), new BigDecimal("27000"), "Sales"),
                new EmployeeEntity("33333333D", "Erica ", "Martinez", 666666663L,
                        LocalDate.of(2017, 6, 26), new BigDecimal("28000"), "Marketing"),
                new EmployeeEntity("44444444E", "Miriam ", "Guzman,", 666666664L,
                        LocalDate.of(2016, 5, 25), new BigDecimal("29000"), "Sanity")
        };
        this.employeeRepository.saveAll(Arrays.asList(employees));

    }

    public void deleteAll() {
        this.productRepository.deleteAll();
    }
}


