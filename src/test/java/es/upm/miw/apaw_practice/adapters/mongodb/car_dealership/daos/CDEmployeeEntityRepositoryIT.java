package es.upm.miw.apaw_practice.adapters.mongodb.car_dealership.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
public class CDEmployeeEntityRepositoryIT {
    @Autowired
    private CDEmployeeRepository employeeRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.employeeRepository.findAll().stream()
                .anyMatch(employee ->
                        employee.getName().equals("Pedro Ramirez") &&
                                employee.getCategory().equals("Limpieza") &&
                                employee.getSeniority().isBefore(LocalDateTime.now()) &&
                                employee.getSalary().equals(new BigDecimal("22000.500")))
        );
    }
}
