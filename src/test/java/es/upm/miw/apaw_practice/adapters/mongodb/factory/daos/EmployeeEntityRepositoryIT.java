package es.upm.miw.apaw_practice.adapters.mongodb.factory.daos;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.adapters.mongodb.factory.entities.EmployeeEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestConfig
public class EmployeeEntityRepositoryIT {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void testFindByDni() {
        assertTrue(this.employeeRepository.findByDni("11111111B").isPresent());
        EmployeeEntity employee = this.employeeRepository.findByDni("11111111B").get();
        assertEquals("Carlos", employee.getName());
        assertEquals("Cob", employee.getLastName());
        assertEquals(666666661L, employee.getPhone());
        assertEquals(LocalDate.of(2019, 8, 28), employee.getSeniority());
        assertEquals(0, new BigDecimal("26000").compareTo(employee.getSalary()));
        assertEquals("Hardware", employee.getDepartment());
    }
}


