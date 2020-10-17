package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.cardealership.daos.CarDealershipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CarDealershipEntityRepositoryIT {
    @Autowired
    private CarDealershipRepository carDealershipRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.carDealershipRepository.findAll().stream()
                .anyMatch(carDealership ->
                        carDealership.getName().equals("Concesionario Castro") &&
                                carDealership.getAddress().equals("Calle Homero, 3") &&
                                666333111L == carDealership.getTelephone() &&
                                carDealership.getEmployees().get(0).getName().equals("Pablo Coronado") &&
                                carDealership.getVehicles().get(0).getBrand().equals("Seat") &&
                                carDealership.getOwner().getName().equals("Pedro"))
        );
    }
}
