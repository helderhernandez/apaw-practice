package es.upm.miw.apaw_practice.adapters.mongodb.cardealership;

import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDEmployeeRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDOwnerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CDVehicleRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CarDealershipRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDEmployeeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDOwnerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CDVehicleEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.entities.CarDealershipEntity;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CarDealershipSeederService {
    @Autowired
    private CDVehicleRepository vehicleRepository;
    @Autowired
    private CDEmployeeRepository employeeRepository;
    @Autowired
    private CDOwnerRepository ownerRepository;
    @Autowired
    private CarDealershipRepository carDealershipRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Car Dealership Initial Load -----------");
        CDVehicleEntity[] vehicles = {
                new CDVehicleEntity("Ford", "Fiesta", true, 2014),
                new CDVehicleEntity("Citroen", "C4", true, 2005),
                new CDVehicleEntity("Seat", "Ateca", false, 2018),
                new CDVehicleEntity("Opel", "Astra", true, 2020),
                new CDVehicleEntity("Opel", "Corsa", true, 2013),
        };

        this.vehicleRepository.saveAll(Arrays.asList(vehicles));

        CDEmployeeEntity[] employees = {
                new CDEmployeeEntity("e2300", "Pablo Coronado", "Comercial", LocalDateTime.of(2018, 10, 28, 16, 20, 10), new BigDecimal("26000.500")),
                new CDEmployeeEntity("e2301","Jesús Pérez", "Comercial", LocalDateTime.of(2017, 12, 13, 17, 20, 40), new BigDecimal("23000.00")),
                new CDEmployeeEntity("e2302","Pedro Ramirez", "Limpieza", LocalDateTime.of(2019, 3, 10, 12, 20, 10), new BigDecimal("22000.500")),
                new CDEmployeeEntity("e2303","Miguel Ángel Muñoz", "Marketing", LocalDateTime.of(2010, 4, 30, 17, 30, 10), new BigDecimal("40000.00")),
                new CDEmployeeEntity("e2304","Laura Jurado", "Marketing", LocalDateTime.of(2013, 4, 1, 13, 3, 20), new BigDecimal("40000.00")),
        };

        this.employeeRepository.saveAll(Arrays.asList(employees));

        CDOwnerEntity[] owners = {
                new CDOwnerEntity("Pedro", "Castro", 667476372L),
                new CDOwnerEntity("Pablo", "Aguza", 663276372L),
                new CDOwnerEntity("Manuel", "Zapata", 717383928L),
                new CDOwnerEntity("Felix", "Montaño", 666233676L),
        };

        this.ownerRepository.saveAll(Arrays.asList(owners));

        CarDealershipEntity[] carDealerships = {
                new CarDealershipEntity("Concesionario Castro", "Calle Homero, 3", 666333111L, List.of(employees[0], employees[3]), List.of(vehicles[2], vehicles[1]), owners[0]),
                new CarDealershipEntity("Concesionario Zapata", "Calle Pelayo, 16", 669933111L, List.of(employees[1], employees[2]), List.of(vehicles[0], vehicles[4]), owners[2]),
        };

        this.carDealershipRepository.saveAll(Arrays.asList(carDealerships));
    }

    public void deleteAll() {
        this.carDealershipRepository.deleteAll();
        this.ownerRepository.deleteAll();
        this.employeeRepository.deleteAll();
        this.vehicleRepository.deleteAll();
    }
}
