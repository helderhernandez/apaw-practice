package es.upm.miw.apaw_practice.adapters.mongodb.factory;

import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.DegreeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.EmployeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.MachineRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.daos.ProductRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.DegreeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.MachineEntity;
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
    @Autowired
    private DegreeRepository degreeRepository;
    @Autowired
    private MachineRepository machineRepository;

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
                        LocalDate.of(2019, 8, 28), new BigDecimal("26000"), "Software"),
                new EmployeeEntity("22222222C", "Carlos ", "Boyero", 666666662L,
                        LocalDate.of(2018, 7, 27), new BigDecimal("27000"), "Sales"),
                new EmployeeEntity("33333333D", "Erica ", "Martinez", 666666663L,
                        LocalDate.of(2017, 6, 26), new BigDecimal("28000"), "Production"),
                new EmployeeEntity("44444444E", "Miriam ", "Guzman,", 666666664L,
                        LocalDate.of(2016, 5, 25), new BigDecimal("29000"), "Production"),
                new EmployeeEntity("55555555F", "Hilario ", "Gomez,", 666666665L,
                        LocalDate.of(2015, 4, 24), new BigDecimal("30000"), "Software"),
                new EmployeeEntity("66666666G", "Isaac ", "Carpena,", 666666666L,
                        LocalDate.of(2014, 3, 23), new BigDecimal("31000"), "Sales"),
                new EmployeeEntity("77777777H", "Ruben ", "Redondo,", 666666667L,
                        LocalDate.of(2013, 2, 22), new BigDecimal("32000"), "Production")
        };
        this.employeeRepository.saveAll(Arrays.asList(employees));

        DegreeEntity[] degrees = {
                new DegreeEntity(employees[0], "Grado en Ingeria de Telecomunicaciones", "123456-7", "Universidad de Alcala"),
                new DegreeEntity(employees[1], "Grado en Ingeria de Telecomunicaciones", "258369-1", "Universidad de Alcala"),
                new DegreeEntity(employees[2], "Grado en Ingenieria Industrial", "456789-1", "Universidad Carlos III de Madrid"),
                new DegreeEntity(employees[3], "Grado en Ingeniria Mecanica", "789123-4", "Universidad Complutense de Madrid"),
                new DegreeEntity(employees[4], "Grado en Ingeria de Telecomunicaciones", "147258-9", "Universidad de Alcala"),
                new DegreeEntity(employees[5], "Grado en Ingeria de Telecomunicaciones", "654789-3", "Universidad de Politecnica de Madrid"),
                new DegreeEntity(employees[6], "Grado en Ingeniria Mecanica", "369147-8", "Universidad Complutense de Madrid"),
                new DegreeEntity(employees[7], "Grado en Ingeniria Mecanica", "321654-9", "Universidad Carlos III de Madrid"),

        };
        this.degreeRepository.saveAll(Arrays.asList(degrees));

        MachineEntity[] machines = {
                new MachineEntity(Arrays.asList(employees[0], employees[1], employees[2]), Arrays.asList(products[0], products[2], products[4]),
                        900600L, false, LocalDate.of(2020, 7, 1)),
                new MachineEntity(Arrays.asList(employees[3], employees[4]), Arrays.asList(products[1], products[2], products[3], products[4]),
                        800500L, true, LocalDate.of(2019, 11, 1)),
                new MachineEntity(Arrays.asList(employees[5], employees[6], employees[7]), Arrays.asList(products[0], products[4]),
                        700500L, true, LocalDate.of(2020, 5, 1)),
        };
        this.machineRepository.saveAll(Arrays.asList(machines));

    }

    public void deleteAll() {
        this.machineRepository.deleteAll();
        this.degreeRepository.deleteAll();
        this.employeeRepository.deleteAll();
        this.productRepository.deleteAll();
    }
}


