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
        assertEquals("Software", employee.getDepartment());
    }

    @Test
    void testFindByDniWithBuilder() {
        EmployeeEntity employeeEntity = EmployeeEntity.builder()
                .dni("xxxxxxxxY")
                .name("Name")
                .lastName("LastName")
                .phone(656565656L)
                .seniority(LocalDate.of(2000, 1, 1))
                .salary(new BigDecimal("50000"))
                .department("CEO")
                .build();

        assertEquals("xxxxxxxxY", employeeEntity.getDni());
        assertEquals("Name", employeeEntity.getName());
        assertEquals("LastName", employeeEntity.getLastName());
        assertEquals(656565656L, employeeEntity.getPhone());
        assertEquals(LocalDate.of(2000, 1, 1), employeeEntity.getSeniority());
        assertEquals(new BigDecimal("50000"), employeeEntity.getSalary());
        assertEquals("CEO", employeeEntity.getDepartment());
    }
}


